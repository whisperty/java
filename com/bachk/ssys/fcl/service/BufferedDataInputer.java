package com.bachk.ssys.fcl.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.bachk.ssys.fcl.model.*;
import com.bachk.ssys.fcl.service.DataInputer;;

public class BufferedDataInputer implements DataInputer {

    private boolean closed; 
    private final int capacity; 
    private int size; 
    private int arrayIndex; 
    private String[] dataBuffer; 
    private BufferedReader in;

    public boolean isAllout() {
		return allout;
	}

	public void setAllout(boolean allout) {
		this.allout = allout;
	}

	private boolean allout;
    private int i=0;
    public BufferedDataInputer(int capacity, BufferedReader in) {
	closed = false;
	this.capacity = capacity;
	size = 0;
	allout = false;
	arrayIndex = 0;
	dataBuffer = new String[this.capacity];
	this.in = in;
	

	try {
	    String curData;
	   

	    do {
	    	curData = in.readLine();
		dataBuffer[size++] =(curData);
		

		if (curData == null) {
			dataBuffer[size++] =(curData);
			this.closeInputer();
		
			
		}
	    }while (size < capacity && curData != null);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void closeInputer() {

	closed = true;
    }

    public boolean isClosed() {
    	return closed;
    }

    public Object readNextData() {
    	SMSModel data;
    
    	if (isClosed()){
    		
    		if((i<=size) && (dataBuffer[i] != null)){
    			
    			String newStr = dataBuffer[i];
    			i++;
    			return  new SMSModel(newStr);
    		}
    		if(i==size+1 ||(dataBuffer[i] == null)){
    			allout = true;
    			return  null;
    		}
    	}
    		
    		

    	if (arrayIndex >= capacity) {
	   
    		updateBuffer();
    	
	    
    		arrayIndex = 0;
	
    	}

	
	
    	if (arrayIndex >= size) {
	    
    		this.closeInputer();
	    
    		return null;
	
    	}

	
	
    
        data = new SMSModel(dataBuffer[arrayIndex]);
	//System.out.println(arrayIndex+" arrayindex" + capacity + "size:'" +size);
    	
    	arrayIndex++;
	
    
	
    	return data;
    
    }

    
    private void updateBuffer() {
    	
    	try {
	    
    		size = 0;
	    String curData;

	    curData = in.readLine();

	    while (size < capacity-1 && curData != null) {
		dataBuffer[size++] = curData;
		curData = in.readLine();
	
	
	    }
	    if((size==capacity-1) && curData != null){
	    	dataBuffer[size++] = curData;
	    	
	    }
		if (curData == null) {
			dataBuffer[size++] =(curData);
		//	System.out.println(size+"  ++++++++++");
			this.closeInputer();
		
		}
	//	System.out.println(dataBuffer[0]+"   );");
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	BufferedReader in;
	 BufferedWriter bw;
	try {
		File files = new File("F:\\abc.txt");  
		if (!files.exists() != false) {  
            try {  
            	files.createNewFile();  
                  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
          }  
		
		 
	    FileReader file = new FileReader("F:\\1.txt");
	    in = new BufferedReader(file);
	    BufferedDataInputer bdi = new BufferedDataInputer(10, in);
	    SMSModel data;
       
        Map<String, String> map = new HashMap<String, String>();
       map.put("type", "State");
       map.put("value", "0     ");
     //  System.out.println(map.get("value"));
        SelectItem newSelect = new SelectItem("State","0");
	    int newvar =1;
	
	    try {  
            bw = new BufferedWriter(new FileWriter(files));  
     
            while (((data = (SMSModel) bdi.readNextData()) != null) ) {
            	 bw.write(newvar++ +"  +"+ data.getByType("State") + newSelect.selectItem(data,"!="));
            	 bw.newLine();//»»ÐÐ  
                 bw.flush();  
         }
             
         
        } catch (Exception e) {  
            e.printStackTrace();  
        }
	  
	  

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

    }

}
