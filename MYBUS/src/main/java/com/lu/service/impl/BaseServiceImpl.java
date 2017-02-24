package com.lu.service.impl;

import java.io.Serializable;

import com.lu.dao.IBaseDao;
import com.lu.service.IBaseService;

public class BaseServiceImpl<T, PK extends Serializable> implements IBaseService<T, PK>{  
    
    private IBaseDao<T, PK> baseDao;  
      
    public IBaseDao<T, PK> getBaseDao() {  
        return baseDao;  
    }  
      
    public void setBaseDao(IBaseDao<T, PK> baseDao) {  
        this.baseDao = baseDao;  
    }  
  
    public T get(PK id) {  
        return baseDao.get(id);  
    }  
      
    public PK save(T entity) {  
        return baseDao.save(entity);  
    }  
  
}  
