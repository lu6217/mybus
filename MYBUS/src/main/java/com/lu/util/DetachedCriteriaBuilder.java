package com.lu.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

public class DetachedCriteriaBuilder extends SerialCloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -34297946281755113L;

	/** The detached criteria. */
	private DetachedCriteria detachedCriteria;

	/** The empty. */
	private boolean empty = true;

	private ProjectionList plist = Projections.projectionList();

	/**
	 * Instantiates a new detached criteria builder.
	 *
	 * @param detachedCriteria
	 *            the detached criteria
	 */
	private DetachedCriteriaBuilder(DetachedCriteria detachedCriteria) {

		this.detachedCriteria = detachedCriteria;
		// this.detachedCriteria.setResultTransformer(Criteria.)

	}

	/**
	 * instance class with model type.
	 *
	 * @param detachedCriteria
	 *            the detached criteria
	 * @return the detached criteria builder
	 */
	public static DetachedCriteriaBuilder instance(DetachedCriteria detachedCriteria) {

		return new DetachedCriteriaBuilder(detachedCriteria);
	}

	/**
	 * instance class.
	 *
	 * @param clazz
	 *            the clazz
	 * @return the detached criteria builder
	 */
	public static DetachedCriteriaBuilder instance(Class<?> clazz) {

		return new DetachedCriteriaBuilder(DetachedCriteria.forClass(clazz));
	}

	/**
	 * instance class with model type & alias.
	 *
	 * @param clazz
	 *            the clazz
	 * @param alias
	 *            the alias
	 * @return the detached criteria builder
	 */
	public static DetachedCriteriaBuilder instance(Class<?> clazz, String alias) {

		return new DetachedCriteriaBuilder(DetachedCriteria.forClass(clazz, alias));
	}

	/**
	 * Checks if is not empty string.
	 *
	 * @param obj
	 *            the obj
	 * @return true, if is not empty string
	 */
	private boolean isNotEmptyString(Object obj) {

		return !(null == obj || (String.class.equals(obj.getClass()) && StringUtils.isEmpty(String.valueOf(obj).trim())));

	}

	/**
	 * equal expression sql ==.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addEq(String property, Object value) {

		if (isNotEmptyString(value)) {
			setEmpty(false);
			detachedCriteria.add(Property.forName(property).eq(value));
			// detachedCriteria.add(Property.forName(property).)
		}
		return this;
	}

	/**
	 * Adds the eq all.
	 *
	 * @param property
	 *            the property
	 * @param values
	 *            the values
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addEqAll(String property, Object[] values) {

		if (ArrayUtils.isNotEmpty(values)) {
			setEmpty(false);
			for (Object value : values) {
				detachedCriteria.add(Property.forName(property).eq(value));
			}
		}
		return this;
	}

	/**
	 * Adds the eq all.
	 *
	 * @param property
	 *            the property
	 * @param values
	 *            the values
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addEqAll(String property, Collection<?> values) {

		if (CollectionUtils.isNotEmpty(values)) {
			setEmpty(false);
			for (Object value : values) {
				detachedCriteria.add(Property.forName(property).eq(value));
			}
		}
		return this;
	}

	/**
	 * Result trans.
	 *
	 * @param reTransformer
	 *            the re transformer
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder resultTrans(ResultTransformer reTransformer) {
		// this.trans = reTransformer;
		this.detachedCriteria.setResultTransformer(reTransformer);
		return this;
	}

	/**
	 * not equal expression sql !=.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addNe(String property, Object value) {

		if (isNotEmptyString(value)) {
			setEmpty(false);
			this.detachedCriteria.add(Property.forName(property).ne(value));
		}
		return this;
	}

	/**
	 * @param property
	 * @return
	 */
	public DetachedCriteriaBuilder addSum(String property) {

		if (isNotEmptyString(property)) {
			setEmpty(false);
			this.detachedCriteria.setProjection(Projections.sum(property));
		}
		return this;
	}

	/**
	 * low than sql <.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addLt(String property, Object value) {

		if (isNotEmptyString(value)) {
			setEmpty(false);
			detachedCriteria.add(Property.forName(property).lt(value));
		}

		return this;
	}

	/**
	 * low than or equal sql <=.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addLe(String property, Object value) {

		if (isNotEmptyString(value)) {
			setEmpty(false);
			detachedCriteria.add(Property.forName(property).le(value));
		}

		return this;
	}

	/**
	 * great than sql >.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addGt(String property, Object value) {

		if (isNotEmptyString(value)) {
			setEmpty(false);
			detachedCriteria.add(Property.forName(property).gt(value));
		}
		return this;
	}

	/**
	 * great than or equal sql >=.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addGe(String property, Object value) {

		if (isNotEmptyString(value)) {
			setEmpty(false);
			detachedCriteria.add(Property.forName(property).ge(value));
		}

		return this;
	}

	/**
	 * between from & to sql between.
	 *
	 * @param property
	 *            the property
	 * @param from
	 *            the from
	 * @param to
	 *            the to
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addBetween(String property, Object from, Object to) {

		if (null != from && null != to) {
			setEmpty(false);
			detachedCriteria.add(Property.forName(property).between(from, to));
		}

		return this;
	}

	/**
	 * sql in.
	 *
	 * @param property
	 *            the property
	 * @param values
	 *            the values
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addIn(String property, Object[] values) {

		if (ArrayUtils.isNotEmpty(values)) {
			setEmpty(false);
			detachedCriteria.add(Property.forName(property).in(values));
		}

		return this;
	}

	/**
	 * sql in.
	 *
	 * @param property
	 *            the property
	 * @param values
	 *            the values
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addIn(String property, Collection<?> values) {

		if (!CollectionUtils.isEmpty(values)) {
			setEmpty(false);
			detachedCriteria.add(Property.forName(property).in(values));
		}

		return this;
	}

	/**
	 * add is null.
	 *
	 * @param property
	 *            the property
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addIsNull(String property) {
		setEmpty(false);
		this.detachedCriteria.add(Property.forName(property).isNull());
		return this;
	}

	/**
	 * add is not null.
	 *
	 * @param property
	 *            the property
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addIsNotNull(String property) {
		setEmpty(false);
		this.detachedCriteria.add(Property.forName(property).isNotNull());
		return this;
	}

	/**
	 * left join.
	 *
	 * @param property
	 *            the property
	 * @param alias
	 *            the alias
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder leftJoin(String property, String alias) {

		this.detachedCriteria.createAlias(property, alias, JoinType.LEFT_OUTER_JOIN);
		return this;
	}

	public DetachedCriteriaBuilder rightJoin(String property, String alias) {

		this.detachedCriteria.createAlias(property, alias, JoinType.RIGHT_OUTER_JOIN);
		return this;
	}

	/**
	 * inner join.
	 *
	 * @param property
	 *            the property
	 * @param alias
	 *            the alias
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder innerJoin(String property, String alias) {
		this.detachedCriteria.createAlias(property, alias, JoinType.INNER_JOIN);
		return this;
	}

	/**
	 * inner join.
	 *
	 * @param property
	 *            the property
	 * @param alias
	 *            the alias
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder createAliasInnerJoin(String property, String alias) {

		this.detachedCriteria.createAlias(property, alias);

		return this;
	}

	/**
	 * Fetch.
	 *
	 * @param property
	 *            the property
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder fetch(String property) {

		this.detachedCriteria.setFetchMode(property, FetchMode.JOIN);
		return this;
	}

	/**
	 * Adds the property eq.
	 *
	 * @param propertyName
	 *            the property name
	 * @param otherPropertyName
	 *            the other property name
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addPropertyEq(String propertyName, String otherPropertyName) {

		this.detachedCriteria.add(Restrictions.eqProperty(propertyName, otherPropertyName));

		return this;
	}

	/**
	 * Adds the property not eq.
	 *
	 * @param propertyName
	 *            the property name
	 * @param otherPropertyName
	 *            the other property name
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addPropertyNotEq(String propertyName, String otherPropertyName) {

		this.detachedCriteria.add(Restrictions.neProperty(propertyName, otherPropertyName));
		return this;
	}

	/**
	 * set property.
	 *
	 * @param property
	 *            the property
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder setGetProperty(String property) {
		setEmpty(false);
		this.detachedCriteria.setProjection(Projections.property(property));
		return this;
	}

	/**
	 * add asc order.
	 *
	 * @param property
	 *            the property
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addAscOrder(String property) {
		setEmpty(false);
		this.detachedCriteria.addOrder(Order.asc(property));
		return this;
	}

	/**
	 * add desc order.
	 *
	 * @param property
	 *            the property
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addDescOrder(String property) {
		setEmpty(false);
		this.detachedCriteria.addOrder(Order.desc(property));
		return this;

	}

	/**
	 * add like case like %value%.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addLikeAny(String property, String value) {

		if (StringUtils.isNotBlank(value)) {
			setEmpty(false);
			this.detachedCriteria.add(Property.forName(property).like(value.trim(), MatchMode.ANYWHERE));
		}

		return this;
	}

	public DetachedCriteriaBuilder addNotContain(String property, String value) {

		if (StringUtils.isNotBlank(value)) {
			setEmpty(false);
			this.detachedCriteria.add(Restrictions.not(Property.forName(property).like(value.trim())));
		}

		return this;
	}

	/**
	 * Adds the like any.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @param caseSensitive
	 *            the case sensitive
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addLikeAny(String property, String value, boolean caseSensitive) {

		if (StringUtils.isNotBlank(value)) {
			setEmpty(false);
			if (caseSensitive) {
				this.detachedCriteria.add(Property.forName(property).like(value.trim(), MatchMode.ANYWHERE));
			} else {
				this.detachedCriteria.add(Restrictions.like(property, value, MatchMode.ANYWHERE).ignoreCase());
			}

		}

		return this;
	}

	/**
	 * add like case like value%.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addLikeStart(String property, String value) {

		if (StringUtils.isNotBlank(value)) {
			setEmpty(false);
			this.detachedCriteria.add(Property.forName(property).like(value.trim(), MatchMode.START));
		}

		return this;
	}

	/**
	 * With exists.
	 *
	 * @param criteria
	 *            the criteria
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder withExists(DetachedCriteria criteria) {

		this.detachedCriteria.add(Subqueries.exists(criteria));

		return this;
	}

	/**
	 * With not exists.
	 *
	 * @param criteria
	 *            the criteria
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder withNotExists(DetachedCriteria criteria) {
		this.detachedCriteria.add(Subqueries.notExists(criteria));
		return this;
	}

	/**
	 * With property in.
	 *
	 * @param propertyName
	 *            the property name
	 * @param criteria
	 *            the criteria
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder withPropertyIn(String propertyName, DetachedCriteria criteria) {
		setEmpty(false);
		this.detachedCriteria.add(Subqueries.propertyIn(propertyName, criteria));
		return this;
	}

	/**
	 * With in.
	 *
	 * @param value
	 *            the value
	 * @param criteria
	 *            the criteria
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder withIn(Object value, DetachedCriteria criteria) {
		setEmpty(false);
		this.detachedCriteria.add(Subqueries.in(value, criteria));
		return this;
	}

	/**
	 * add like case like %value.
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addLikeEnd(String property, String value) {

		if (StringUtils.isNotBlank(value)) {
			setEmpty(false);
			this.detachedCriteria.add(Property.forName(property).like(value.trim(), MatchMode.END));
		}

		return this;
	}

	/**
	 * add PropertyOr.
	 *
	 * @param property
	 *            the property
	 * @param lValue
	 *            the l value
	 * @param rValue
	 *            the r value
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addPropertyOr(String property, Object lValue, Object rValue) {
		setEmpty(false);
		this.detachedCriteria.add(Restrictions.or(Restrictions.eq(property, lValue), Restrictions.eq(property, rValue)));
		return this;
	}

	/**
	 * add or.
	 *
	 * @param propertyOne
	 *            the property one
	 * @param valueOne
	 *            the value one
	 * @param propertyTwo
	 *            the property two
	 * @param valueTwo
	 *            the value two
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addOr(String propertyOne, Object valueOne, String propertyTwo, Object valueTwo) {
		setEmpty(false);
		this.detachedCriteria.add(Restrictions.or(Restrictions.eq(propertyOne, valueOne), Restrictions.eq(propertyTwo, valueTwo)));
		return this;
	}

	/**
	 * add propertyOr.
	 *
	 * @param propertyOne
	 *            the property one
	 * @param valueOne
	 *            the other property name
	 * @param propertyTwo
	 *            the property two
	 * @param valueTwo
	 *            the other property name
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addPropertyOr(String propertyOne, String otherPropertyOne, String propertyTwo, String otherPropertyTwo) {
		setEmpty(false);
		this.detachedCriteria.add(Restrictions.or(Restrictions.eqProperty(propertyOne, otherPropertyOne),
				Restrictions.eqProperty(propertyTwo, otherPropertyTwo)));
		return this;
	}

	/**
	 * Adds the or.
	 *
	 * @param exps
	 *            the exps
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addOr(ConditionExp... exps) {

		Disjunction dis = Restrictions.disjunction();

		for (ConditionExp single : exps) {
			if (!single.isSkip()) {
				if (single.getClass().equals(Like.class)) {
					setEmpty(false);
					dis.add(Restrictions.like(single.getProperty(), (String) single.getValue(), MatchMode.ANYWHERE).ignoreCase());
				} else if (single.getClass().equals(Eq.class)) {
					setEmpty(false);
					dis.add(Restrictions.eq(single.getProperty(), single.getValue()));
				} else if (single.getClass().equals(In.class)) {
					setEmpty(false);
					In in = (In) single;
					dis.add(Restrictions.in(in.getProperty(), in.getValue()));
				}
			}
		}

		this.detachedCriteria.add(dis);

		return this;
	}

	/**
	 * Adds the or.
	 *
	 * @param criterions
	 *            the criterions
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addOr(Criterion... criterions) {

		Disjunction dis = Restrictions.disjunction();
		if (ArrayUtils.isNotEmpty(criterions)) {
			setEmpty(false);
			for (Criterion single : criterions) {
				dis.add(single);
			}

			this.detachedCriteria.add(dis);
		}

		return this;
	}

	/**
	 * get detached criteria.
	 *
	 * @return the detached criteria
	 */
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}

	/**
	 * set projection.
	 *
	 * @param pj
	 *            the pj
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder setProjection(Projection pj) {
		plist.add(pj);
		this.detachedCriteria.setProjection(plist);
		return this;
	}

	/**
	 * set order.
	 *
	 * @param orderName
	 *            the order name
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder setOrder(String orderName) {
		if (StringUtils.isNotBlank(orderName)) {
			setEmpty(false);
			for (String order : orderName.split("\\|")) {
				String[] orderField = order.split(",");
				if (orderField.length == 1) {
					this.addAscOrder(orderField[0]);
				}
				if (orderField.length == 2) {
					if (StringUtils.lowerCase(orderField[1]).equals("asc")) {
						this.addAscOrder(orderField[0]);
					} else {
						this.addDescOrder(orderField[0]);
					}
				}

			}
		}
		return this;
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return empty;
	}

	/**
	 * Sets the empty.
	 *
	 * @param empty
	 *            the new empty
	 */
	private void setEmpty(boolean empty) {
		this.empty = empty;
	}

	/**
	 * Adds the exists subquery, subquery Entity must have @Id property builder
	 * has its own query,otherwise use @see #withExists.
	 *
	 * @param builder
	 *            the builder
	 * @return the detached criteria builder
	 */
	public DetachedCriteriaBuilder addExists(DetachedCriteriaBuilder builder) {
		if (!builder.isEmpty()) {
			builder.setProjection(Projections.id());
			this.detachedCriteria.add(Subqueries.exists(builder.getDetachedCriteria()));
		}
		return this;
	}

	public DetachedCriteriaBuilder addNotExists(DetachedCriteriaBuilder builder) {
		if (!builder.isEmpty()) {
			builder.setProjection(Projections.id());
			this.detachedCriteria.add(Subqueries.notExists(builder.getDetachedCriteria()));
		}
		return this;
	}
	//

	public DetachedCriteriaBuilder addExistsOrEq(DetachedCriteriaBuilder builder, String property, Object value) {
		if (!builder.isEmpty()) {
			builder.setProjection(Projections.id());
			this.detachedCriteria.add(Restrictions.or(Subqueries.exists(builder.getDetachedCriteria()), Restrictions.eq(property, value)));
		} else {
			this.addEq(property, value);
		}
		return this;
	}

	public DetachedCriteriaBuilder addExistsOrBetween(DetachedCriteriaBuilder builder, String property, Object value1, Object value2) {
		if (!builder.isEmpty()) {
			builder.setProjection(Projections.id());
			this.detachedCriteria
					.add(Restrictions.or(Subqueries.exists(builder.getDetachedCriteria()), Restrictions.between(property, value1, value1)));
		} else {
			this.addBetween(property, value1, value2);
		}
		return this;
	}

	public DetachedCriteriaBuilder addDTOTransform(Class<?> clazz) {
		this.detachedCriteria.setResultTransformer(Transformers.aliasToBean(clazz));
		return this;
	}

	/**
	 * set projection
	 * 
	 * @param pj
	 * @return
	 */
	public DetachedCriteriaBuilder setProjection(Projection pj, String alias) {
		if (StringUtils.isNotBlank(alias)) {
			plist.add(Projections.alias(pj, alias));
			this.detachedCriteria.setProjection(plist);
		} else {
			setProjection(pj);
		}
		return this;
	}

}

class SerialCloneable implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7417445648006480911L;

	public Object clone() {

		ByteArrayOutputStream bout = null;
		ObjectOutputStream out = null;

		try {
			bout = new ByteArrayOutputStream();
			out = new ObjectOutputStream(bout);
			out.writeObject(this);
			// close bout
			ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bin);
			Object ret = in.readObject();
			// close out
			return ret;
		} catch (Exception e) {
			return new RuntimeException(e);
		} finally {
			IOCloseUtils.closeBatch(bout, out);
		}
	}
}