package com.bachk.ssys.fcl.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

public class SelectItem {
	public SelectItem(String type, String value) {
		super();
		this.type = type;
		this.value = value;
	}
	public SelectItem() {
		super();
		this.type = "";
		this.value = "";
	}

	private String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String value;
	
	public boolean selectItem(SMSModel newSMS,String operator){
//			System.out.println(this.getType().length());
//			System.out.println(newSMS.getState());
//				System.out.println(newSMS.getByType(this.getType()) + "=" +this.getValue());
		if (newSMS.getByType(type) !=null){
			if(operator.equals("=="))
				return ( newSMS.getByType(type).equals(value));
			else if (operator.equals("!="))
				return !( newSMS.getByType(type).equals(value));
			else if (operator.equals(">"))
				return ( newSMS.getByType(type).compareTo(value)) > 0 ;
			else if (operator.equals("<"))
				return ( newSMS.getByType(type).compareTo(value)) < 0 ;
			else 
				return false;
		}else
			return false;
		
	
		
	}
	
	

}
