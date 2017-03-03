package com.lu.entity.enumType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum OrderStatus {
	OrderStatus_ToPay("��֧��"),
	OrderStatus_Paied("��֧��"),
	OrderStatus_WaitForAboard("��֧�����˳�"),
	OrderStatus_Canceled("��ȡ��"),
	OrderStatus_Unsubscribe("���˶�"),
	OrderStatus_Closed("�ѹر�"),
	OrderStatus_Finished("�����");
	
	String description;
	
	OrderStatus(String description){
		this.description = description;
	}
	
    public static OrderStatus get(String source) {
    	for (OrderStatus e : values()) {
    		if(e.toString().equals(source)) {
    			return e;
    		}
    	}
    	return null;
    }

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	private static List<Map<String, String>> list= null;
	
	static{
		list = new ArrayList<>();
		for (OrderStatus e : values()) {
    		Map<String, String> result = new HashMap<String, String>();
    		result.put("id", e.name());
    		result.put("name", e.getDescription());
    		list.add(result);
    	}
	}
	
    public static List<Map<String, String>> getAvailableTypes() {
    	return list;
    }
    
    public boolean canUnsubscribe() {
    	return this.equals(OrderStatus_WaitForAboard);
    }
    
}
