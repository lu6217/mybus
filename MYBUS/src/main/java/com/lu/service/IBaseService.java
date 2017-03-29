package com.lu.service;

import java.io.Serializable;

public interface IBaseService<T, PK extends Serializable> {  
  
    
	/**
	 * 
	 * @param id
	 * @return
	 */
    public T get(PK id);  
      
	/**
	 * 
	 * @param entity
	 * @return
	 */
    public PK save(T entity);  
}  