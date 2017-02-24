package com.lu.service;

import java.io.Serializable;  

public interface IBaseService<T, PK extends Serializable> {  
  
    
	 /** 
     * ����ID��ȡʵ�����. 
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