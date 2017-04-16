package com.lu.dao;

import java.io.Serializable;

public interface IBaseDao<T, PK extends Serializable> {  
	  
	   /** 
     * ���ID��ȡʵ�����. 
     *  
     * @param id 
     *            ��¼ID 
     * @return ʵ����� 
     */  
    public T get(PK id);  
      
    /** 
     * ����ʵ�����. 
     *  
     * @param entity 
     *            ���� 
     * @return ID 
     */  
    public PK save(T entity);  
}  