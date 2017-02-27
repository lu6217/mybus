package com.lu.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.reflect.FieldUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;

import com.google.common.collect.Lists;
import com.lu.util.hibernate.CriteriaSearchCallback;

public abstract class BaseDAO<T> {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/** The type. */
	private Class<T> type;

	/** The flush count. */
	private int flushCount = 20;

	/**
	 * Instantiates a new base dao.
	 */
	public BaseDAO() {

		injectType();
	}

	/**
	 * Inject type.
	 */
	@SuppressWarnings("unchecked")
	protected void injectType() {
		Class<?> c = getClass();

		java.lang.reflect.Type type = c.getGenericSuperclass();

		if (type instanceof ParameterizedType) {
			java.lang.reflect.Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
			this.type = (Class<T>) parameterizedType[0];
			this.flushCount = SystemConfigHolder.instance().getInterger("system.db.flush.count", 100);
		}
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	protected Class<T> getType() {
		return type;
	}

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Gets the current session.
	 *
	 * @return the current session
	 */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Checks if is exist.
	 *
	 * @param id
	 *            the id
	 * @return true, if is exist
	 */
	public boolean isExist(Serializable id) {

		T obj = selectById(id);
		return obj == null ? false : true;

	}

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public T selectById(Serializable id) {

		Session session = getCurrentSession();
		Object object = session.get(type, id);
		return (T) object;

	}

	/**
	 * Select all.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<T> selectAll() {

		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(type);
		return criteria.list();

	}

	/**
	 * Select all.
	 *
	 * @param isDelete
	 *            the is delete
	 * @return the list
	 */
	public List<T> selectAll(boolean isDelete) {

		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(type);

		if (isInheritedPrivateFields(type, "delete")) {
			builder.addEq("delete", isDelete);
		}

		builder.addAscOrder(getEntityIdName());
		return select(builder);

	}

	/**
	 * Checks if is inherited private fields.
	 *
	 * @param type
	 *            the type
	 * @param fieldName
	 *            the field name
	 * @return true, if is inherited private fields
	 */
	private boolean isInheritedPrivateFields(Class<?> type, String fieldName) {
		List<Field> result = Lists.newArrayList();

		Class<?> i = type;
		while (i != null && i != Object.class) {
			result.add(FieldUtils.getDeclaredField(i, fieldName));
			i = i.getSuperclass();
		}

		return CollectionUtils.isNotEmpty(result);
	}

	/**
	 * Count all.
	 *
	 * @return the long
	 */
	@SuppressWarnings("rawtypes")
	public Long countAll() {

		final String entityName = getEntityName();
		final String HQL_COUNT_ALL = String.format("select count(*) from %s", entityName);
		Session session = getCurrentSession();
		Query query = session.createQuery(HQL_COUNT_ALL);
		List list = query.list();

		return CollectionUtils.isEmpty(list) ? 0 : (Long) list.get(0);

	}

	/**
	 * Select.
	 *
	 * @param builder
	 *            the builder
	 * @return the list
	 */
	public List<T> select(DetachedCriteriaBuilder builder) {
		return selectE(builder);
	}

	/**
	 * Select e.
	 *
	 * @param <E>
	 *            the element type
	 * @param builder
	 *            the builder
	 * @return the list
	 */
	public <E> List<E> selectE(DetachedCriteriaBuilder builder) {

		CriteriaSearchCallback<List<E>> callback = new CriteriaSearchCallback<List<E>>();
		callback.setCriteria(builder.getDetachedCriteria());

		// getCurrentSession().createCriteria(persistentClass)
		List<E> list = Lists.newArrayList();
		try {
			list = callback.doInHibernate(getCurrentSession());
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	/**
	 * Select e.
	 *
	 * @param <E>
	 *            the element type
	 * @param callback
	 *            the callback
	 * @return the list
	 */
	public <E> List<E> selectE(HibernateCallback<List<E>> callback) {

		List<E> list = Lists.newArrayList();
		try {
			list = callback.doInHibernate(getCurrentSession());
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	/**
	 * Select top one.
	 *
	 * @param builder
	 *            the builder
	 * @return the t
	 */
	public T selectTopOne(DetachedCriteriaBuilder builder) {
		List<T> list = selectTopN(builder, 1);
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
	}

	/**
	 * Select top one.
	 *
	 * @param hql
	 *            the hql
	 * @param objs
	 *            the objs
	 * @return the object
	 */
	public Object selectTopOne(String hql, Object[] objs) {

		Session session = getCurrentSession();
		Query query = session.createQuery(hql);
		if (ArrayUtils.isNotEmpty(objs)) {
			int i = 0;
			for (Object obj : objs) {
				query.setParameter(i++, obj);
			}
		}
		@SuppressWarnings("rawtypes")
		List list = query.list();
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
	}

	/**
	 * Select top n.
	 *
	 * @param builder
	 *            the builder
	 * @param n
	 *            the n
	 * @return the list
	 */
	public List<T> selectTopN(DetachedCriteriaBuilder builder, int n) {

		PagingVO param = new PagingVO();
		param.setPageIndex("1");
		param.setPageSize(Integer.toString(n));
		List<T> res = (List<T>) selectPaging(builder, param);
		return res;
	}

	/**
	 * Select top ne.
	 *
	 * @param <E>
	 *            the element type
	 * @param builder
	 *            the builder
	 * @param n
	 *            the n
	 * @return the list
	 */
	public <E> List<E> selectTopNE(DetachedCriteriaBuilder builder, int n) {
		PagingVO param = new PagingVO();
		param.setPageIndex("1");
		param.setPageSize(Integer.toString(n));
		@SuppressWarnings("unchecked")
		List<E> res = (List<E>) selectPaging(builder, param);
		return res;
	}

	public <E> E selectTopE(DetachedCriteriaBuilder builder) {

		List<E> res = selectTopNE(builder, 1);
		return CollectionUtils.isEmpty(res) ? null : res.get(0);
	}

	/**
	 * Select paging.
	 *
	 * @param builder
	 *            the builder
	 * @param page
	 *            the page
	 * @return the list
	 */
	List<T> selectPaging(DetachedCriteriaBuilder builder, PagingVO page) {

		builder.setOrder(page.getOrderName());
		DetachedCriteria criteria = builder.getDetachedCriteria();

		PagingCriteriaSearchCallback<List<T>> searchCallback = new PagingCriteriaSearchCallback<List<T>>(criteria);
		searchCallback.setPageIndex(page.getPageIndex()).setPageSize(page.getPageSize());

		List<T> list = Lists.newArrayList();
		try {
			list = searchCallback.doInHibernate(getCurrentSession());
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	/**
	 * Select list.
	 *
	 * @param builder
	 *            the builder
	 * @return the list
	 */
	List<T> selectList(DetachedCriteriaBuilder builder) {

		DetachedCriteria criteria = builder.getDetachedCriteria();
		// criteria.setResultTransformer(resultTransformer)
		CriteriaSearchCallback<List<T>> csc = new CriteriaSearchCallback<>(criteria);
		try {
			return csc.doInHibernate(getCurrentSession());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Query single.
	 *
	 * @param builder
	 *            the builder
	 * @return the t
	 */
	public T querySingle(DetachedCriteriaBuilder builder) {

		builder.getDetachedCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<T> mes = select(builder);

		if (CollectionUtils.isNotEmpty(mes)) {
			return mes.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Select paging e.
	 *
	 * @param <E>
	 *            the element type
	 * @param builder
	 *            the builder
	 * @param page
	 *            the page
	 * @return the list
	 */
	public <E> List<E> selectPagingE(DetachedCriteriaBuilder builder, PagingVO page) {

		PagingCriteriaSearchCallback<List<E>> searchCallback = new PagingCriteriaSearchCallback<List<E>>(
				builder.getDetachedCriteria());
		searchCallback.setPageIndex(page.getPageIndex()).setPageSize(page.getPageSize());
		List<E> list = Lists.newArrayList();
		try {
			list = searchCallback.doInHibernate(getCurrentSession());
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	/**
	 * Select paging vo.
	 *
	 * @param queryBuilder
	 *            the query builder
	 * @param page
	 *            the page
	 * @param countBuilder
	 *            the count builder
	 * @return the paging vo
	 */
	public PagingVO selectPagingVO(DetachedCriteriaBuilder queryBuilder, PagingVO page,
			DetachedCriteriaBuilder countBuilder) {

		// queryBuilder.setOrder(page.getOrderName());
		page.setDetails(selectPaging(queryBuilder, page));
		page.setCount(count(countBuilder));
		return page;
	}

	/**
	 * 
	 * @param query
	 * @param page
	 * @return the paging vo
	 */
	@SuppressWarnings("unchecked")
	public PagingVO selectPagingVO(Query query, PagingVO page) {
		List<T> countResult = query.list();
		if (CollectionUtils.isNotEmpty(countResult)) {
			page.setCount(Long.valueOf(countResult.size()));
			query.setFirstResult(Integer.valueOf(page.getPageIndex()))
					.setMaxResults(Integer.valueOf(page.getPageSize()));
			page.setDetails(query.list());
		} else {
			page.setCount(0l);
			page.setDetails(Collections.EMPTY_LIST);
		}
		return page;
	}

	/**
	 * Count.
	 *
	 * @param builder
	 *            the builder
	 * @return the long
	 */
	public Long count(DetachedCriteriaBuilder builder) {

		builder.setProjection(Projections.rowCount());
		return (Long) builder.getDetachedCriteria().getExecutableCriteria(getCurrentSession()).uniqueResult();
	}

	/**
	 * Save.
	 *
	 * @param t
	 *            the t
	 * @return the serializable
	 */
	public Serializable save(T t) {
		checkMutable();
		Session session = getCurrentSession();
		return session.save(t);
	}

	/**
	 * Delete.
	 *
	 * @param t
	 *            the t
	 */
	public void delete(T t) {
		checkMutable();
		Session session = getCurrentSession();
		session.delete(t);
	}

	/**
	 * Delete by id.
	 *
	 * @param id
	 *            the id
	 */
	public void deleteById(Serializable id) {

		checkMutable();
		Session session = getCurrentSession();
		Object object = session.get(type, id);
		session.delete(object);

	}

	/**
	 * Update.
	 *
	 * @param t
	 *            the t
	 */
	public void update(T t) {
		checkMutable();
		Session session = getCurrentSession();
		session.update(t);
	}

	/**
	 * Save or update.
	 *
	 * @param t
	 *            the t
	 */
	public void saveOrUpdate(T t) {
		checkMutable();
		Session session = getCurrentSession();
		session.saveOrUpdate(t);
	}

	/**
	 * Merge.
	 *
	 * @param t
	 *            the t
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public T merge(T t) {
		checkMutable();
		Session session = getCurrentSession();
		return (T) session.merge(t);
	}

	/**
	 * Save or update batch.
	 *
	 * @param ts
	 *            the ts
	 */
	public void saveOrUpdateBatch(Collection<T> ts) {

		saveOrUpdateBatch(ts, flushCount);
	}

	/**
	 * Save or update batch.
	 *
	 * @param ts
	 *            the ts
	 * @param flushCount
	 *            the flush count
	 */
	public void saveOrUpdateBatch(Collection<T> ts, int flushCount) {

		if (CollectionUtils.isNotEmpty(ts)) {
			int i = 0;
			for (T t : ts) {
				this.saveOrUpdate(t);
				if (i > 0 && i++ % flushCount == 0) {
					getCurrentSession().flush();
				}
			}
		}
	}

	/**
	 * Select all.
	 *
	 * @param <E>
	 *            the element type
	 * @param hql
	 *            the hql
	 * @param objects
	 *            the objects
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public <E> List<E> selectAll(String hql, Object... objects) {

		Query query = this.getCurrentSession().createQuery(hql);

		if (ArrayUtils.isNotEmpty(objects)) {
			String[] namedParameters = query.getNamedParameters();
			if (ArrayUtils.isEmpty(namedParameters)) {
				int i = 0;
				for (Object obj : objects) {
					query.setParameter(i++, obj);
				}
			} else {
				List<String> namedParams = Arrays.asList(namedParameters);
				Collections.sort(namedParams);
				int i = 0;
				for (Object obj : objects) {
					if (obj instanceof Collection) {
						if (namedParams == null || namedParams.size() == 0) {
							throw new HibernateException("HQL includes list, but there is no named parameter set!");
						}
						Collection<?> vals = (Collection<?>) obj;
						query.setParameterList(namedParams.get(i++), vals);
					} else {
						query.setParameter(namedParams.get(i++), obj);
					}
				}
			}

		}
		return query.list();
	}

	/**
	 * Bulk update. 注意命名参数必须按字母排序
	 *
	 * @param hql
	 *            the hql
	 * @param objects
	 *            the objects
	 * @return the int
	 */
	public int bulkUpdate(String hql, Object... objects) {

		Query query = this.getCurrentSession().createQuery(hql);

		if (ArrayUtils.isNotEmpty(objects)) {
			String[] namedParameters = query.getNamedParameters();
			if (ArrayUtils.isEmpty(namedParameters)) {
				int i = 0;
				for (Object obj : objects) {
					query.setParameter(i++, obj);
				}
			} else {
				List<String> namedParams = Arrays.asList(namedParameters);
				Collections.sort(namedParams);
				int i = 0;
				for (Object obj : objects) {
					if (obj instanceof Collection) {
						if (namedParams == null || namedParams.size() == 0) {
							throw new HibernateException("HQL includes list, but there is no named parameter set!");
						}
						Collection<?> vals = (Collection<?>) obj;
						query.setParameterList(namedParams.get(i++), vals);
					} else {
						query.setParameter(namedParams.get(i++), obj);
					}
				}
			}

		}
		return query.executeUpdate();
	}

	/**
	 * Delete batch.
	 *
	 * @param ts
	 *            the ts
	 */
	public void deleteBatch(Collection<T> ts) {

		saveOrUpdateBatch(ts, flushCount);
	}

	/**
	 * Delete batch.
	 *
	 * @param ts
	 *            the ts
	 * @param flushCount
	 *            the flush count
	 */
	public void deleteBatch(Collection<T> ts, int flushCount) {

		if (CollectionUtils.isNotEmpty(ts)) {
			int i = 0;
			for (T t : ts) {
				this.delete(t);
				if (i > 0 && i++ % flushCount == 0) {
					getCurrentSession().flush();
				}
			}
		}
	}

	/**
	 * Flush and clear.
	 */
	public void flushAndClear() {

		Session session = getCurrentSession();
		session.flush();
		// session.clear();

	}

	/**
	 * Check mutable.
	 */
	private void checkMutable() {
		boolean mutable = getSessionFactory().getClassMetadata(this.type).isMutable();

		if (!mutable) {
			throw new RuntimeException("Try to save imutable enity !");
		}
	}

	/**
	 * Gets the entity id name.
	 *
	 * @return the entity id name
	 */
	private String getEntityIdName() {

		String idName = getSessionFactory().getClassMetadata(this.type).getIdentifierPropertyName();
		return idName;
	}

	/**
	 * Gets the entity name.
	 *
	 * @return the entity name
	 */
	private String getEntityName() {
		return sessionFactory.getClassMetadata(type).getEntityName();
	}

	/**
	 * Delete by properties.
	 *
	 * @param properties
	 *            the properties
	 * @param values
	 *            the values
	 * @return the int
	 */
	public int deleteByProperties(String[] properties, Object[] values) {
		if (ArrayUtils.isNotEmpty(properties)) {
			String and = " and";
			StringBuilder builder = new StringBuilder("delete from ");
			builder.append(getEntityName()).append(" a where");
			for (String property : properties) {
				builder.append(" a.").append(property).append("=?").append(and);
			}

			return bulkUpdate(builder.toString().substring(0, builder.length() - and.length()), values);

		}

		return 0;

	}

	/**
	 * Scroll.
	 *
	 * @param builder
	 *            the builder
	 * @return the scrollable results
	 */
	public ScrollableResults scroll(DetachedCriteriaBuilder builder) {

		return builder.getDetachedCriteria().getExecutableCriteria(this.getCurrentSession())
				.scroll(ScrollMode.FORWARD_ONLY);

	}
}
