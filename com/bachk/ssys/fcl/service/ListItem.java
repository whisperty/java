package com.bachk.ssys.fcl.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;



import com.bachk.ssys.fcl.model.SMSModel;
import com.bachk.ssys.fcl.model.SelectItem;
@Service
@RemotingDestination
public class ListItem {
	
	private String opentPath;

	private 	BufferedReader in;

	 BufferedDataInputer bdi;

	
	@RemotingInclude
	public void init(String path)
	{
		
	
		this.opentPath = path;
	
		
	}
	
	
	          
	public void openinFile(){
		
		
		try{
	    FileReader file = new FileReader(opentPath);
			//FileReader file = new FileReader(opentPath);
		    in = new BufferedReader(file);
		    bdi = new BufferedDataInputer(10, in);
		
		}    catch (IOException e) {  
				e.printStackTrace();  
		}    
	
}

	@RemotingInclude
	public List<SMSModel> listAllItem(){
		
	

		this.openinFile();
	    SMSModel data;
        ArrayList<SMSModel> list = new ArrayList<SMSModel>();

	 
	        try {  
	        
	        	while (((data = (SMSModel) bdi.readNextData()) != null) ) {
	        		list.add(data);
	        		
   		    }
         
     
	        } catch (Exception e) {  
	        	e.printStackTrace();  
	        }
  
		

	        return list;

    }
}
