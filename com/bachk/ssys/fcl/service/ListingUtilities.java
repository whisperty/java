package com.bachk.ssys.fcl.service;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class ListingUtilities {

	public static void setPagingParams(Criteria c, Map options){
		if (options.get("firstResult") != null){
			c.setFirstResult((Integer)options.get("firstResult"));
		}
		if (options.get("maxResults") != null){
			c.setMaxResults((Integer)options.get("maxResults"));
		}
	}
	
	public static void setOrderParams(Criteria c, Map options, String defaultSortField){
		String order = defaultSortField;
		if (options.get("sortField") != null){
			order = (String)options.get("sortField");
		}
		if (Boolean.TRUE.equals(options.get("descending"))){
			c.addOrder(Order.desc(order));
		}else{
			c.addOrder(Order.asc(order));
		}
	}
	
}
