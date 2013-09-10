package com.bachk.ssys.fcl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RemotingDestination
public class AccountService {

	
	
	@RemotingInclude
	
	public void list(Map options) {
		if (options == null) 
			options = new HashMap();
		
	
	}
	
	public void prepareFilterOptions(Criteria c, Map options){
		if (options.get("filterStr") != null){
			String filterStr = (String) options.get("filterStr");
			c.add(
					Restrictions.like("username", filterStr, MatchMode.ANYWHERE)
			);
		}
	}
	
	
	@RemotingInclude
	public String save1(){
		return "123";
	}
	
	
	

	
}
