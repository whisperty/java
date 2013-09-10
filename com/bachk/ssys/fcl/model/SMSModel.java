package com.bachk.ssys.fcl.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.bachk.ssys.fcl.service.BufferedDataInputer;

public class SMSModel {
	public String getIMSI() {
		return IMSI;
	}
	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		duration = duration;
	}
	public String getMSISDN() {
		return MSISDN;
	}
	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getVLR() {
		return VLR;
	}
	public void setVLR(String vLR) {
		VLR = vLR;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getHLR() {
		return HLR;
	}
	public void setHLR(String hLR) {
		HLR = hLR;
	}
	public String getSour_lac() {
		return sour_lac;
	}
	public void setSour_lac(String sour_lac) {
		this.sour_lac = sour_lac;
	}
	public String getSour_ci() {
		return sour_ci;
	}
	public void setSour_ci(String sour_ci) {
		this.sour_ci = sour_ci;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		state = state;
	}
	public String getEnd_ci() {
		return end_ci;
	}
	public void setEnd_ci(String end_ci) {
		this.end_ci = end_ci;
	}
	public String getCause_ID() {
		return cause_ID;
	}
	public void setCause_ID(String cause_ID) {
		this.cause_ID = cause_ID;
	}
	public String getLAC() {
		return LAC;
	}
	public void setLAC(String lAC) {
		LAC = lAC;
	}
	public String getDest_lac() {
		return dest_lac;
	}
	public void setDest_lac(String dest_lac) {
		this.dest_lac = dest_lac;
	}
	public String getDest_ci() {
		return dest_ci;
	}
	public void setDest_ci(String dest_ci) {
		this.dest_ci = dest_ci;
	}
	public String getOppo_num() {
		return oppo_num;
	}
	public void setOppo_num(String oppo_num) {
		this.oppo_num = oppo_num;
	}
	public String getSend_Stamp() {
		return send_Stamp;
	}
	public void setSend_Stamp(String send_Stamp) {
		send_Stamp = send_Stamp;
	}
	public String getReceive_Stamp() {
		return receive_Stamp;
	}
	public void setReceive_Stamp(String receive_Stamp) {
		receive_Stamp = receive_Stamp;
	}
	private String IMSI; 
	private String event_type; 
	private String duration; 
	private String MSISDN; 
	private String IMEI; 
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	private int index;
	private String VLR; 
	private String cause; 
	private String HLR; 
	private String sour_lac; 
	private String sour_ci; 
	private String state; 
	private String end_ci; 
	private String cause_ID; 
	private String LAC; 
	private String dest_lac; 
	private String dest_ci; 
	private String oppo_num; 
	private String send_Stamp; 
	private String receive_Stamp; 
	private  boolean succeed;
	public SMSModel(String str1) {
		super();
		// TODO Auto-generated constructor stub
		if(str1 == null)
			this.succeed = false;
		else
		{
		StringTokenizer st = new StringTokenizer(str1,"\"");
		
			index = 0;
			this.IMSI = (st.nextToken()).replace(" ", "");
			st.nextToken();
		
			 event_type= st.nextToken().replace(" ", "");
			 st.nextToken();
			 duration= st.nextToken().replace(" ", "");
			 st.nextToken();
			 MSISDN= st.nextToken().replace(" ", "");
			 st.nextToken();
			IMEI= st.nextToken().replace(" ", "");
			st.nextToken();
			
			VLR= st.nextToken().replace(" ", "");
			st.nextToken();
			 cause = st.nextToken().replace(" ", ""); 
			 st.nextToken();
			 HLR= st.nextToken().replace(" ", "");
			 st.nextToken();
			sour_lac= st.nextToken().replace(" ", "");
			st.nextToken();
			 sour_ci= st.nextToken().replace(" ", "");
			 st.nextToken();
			state= st.nextToken().replace(" ", "");
			st.nextToken();
			 end_ci= st.nextToken().replace(" ", "");
			 st.nextToken();
			 cause_ID= st.nextToken().replace(" ", ""); 
			 st.nextToken();
			 LAC= st.nextToken().replace(" ", ""); 
			 st.nextToken();
			dest_lac= st.nextToken().replace(" ", "");
			st.nextToken();
			 dest_ci= st.nextToken().replace(" ", ""); 
			 st.nextToken();
			 st.nextToken();
			 st.nextToken();
			 oppo_num= st.nextToken().replace(" ", "");
			 st.nextToken();
			 send_Stamp= st.nextToken().replace(" ", "");
			 st.nextToken();
			receive_Stamp = st.nextToken().replace(" ", ""); 
		
		}
			
	}
	public SMSModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getByType(String type){
	
		if(type.equals("IMSI" ))
			return this.getIMSI();
		if(type.equals("event_type") )
		    return this.getEvent_type();
		if(type.equals("duration" ))
		    return this.getDuration();
		if(type.equals("MSISDN" ))
		    return this.getMSISDN();
		if(type.equals("IMEI") )
		    return this.getIMEI();
		if(type.equals("VLR") )
		    return this.getVLR();
		if(type.equals("cause") )
		    return this.getCause();
		if(type.equals("HLR") )
		    return this.getHLR();
		if(type.equals("sour_lac") )
		    return this.getSour_lac();
		if(type.equals("sour_ci") )
		    return this.getSour_ci();
		if(type.equals("state") )
		    return this.getState();
		if(type.equals("end_ci") )
		    return this.getEnd_ci();
		if(type.equals("cause_ID") )
		    return this.getCause_ID();
		if(type.equals("LAC") )
		    return this.getLAC();
		if(type.equals("dest_lac") )
		    return this.getDest_lac();
		
		
		if(type.equals("dest_ci") )
		    return this.getDest_ci();
		if(type.equals("oppo_num") )
		    return this.getOppo_num();
		if(type.equals("send_Stamp") )
		    return this.getSend_Stamp();
		if(type.equals("receive_Stamp") )
		    return this.getReceive_Stamp();
		return null;
		 
		 
		
		
	}
	
	  @Override
	public String toString() {

		return "\"" + IMSI + "\" \"" + event_type
				+ "\" \"" + duration + "\" \"" + MSISDN + "\" \""
				+ IMEI + "\" \"" + VLR + "\" \"" + cause + "\" \"" + HLR
				+ "\" \"" + sour_lac + "\" \"" + sour_ci
				+ "\" \"" + state + "\" \"" + end_ci + "\" \""
				+ cause_ID + "\" \"" + LAC + "\" \"" + dest_lac
				+ "\" \"" + dest_ci + "\" \"      \" \"" + oppo_num
				+"\" \"" + send_Stamp + "\" \""
				+ receive_Stamp + "\"";
	}
	public static void main(String[] args) {
		  try {
		  FileReader file = new FileReader("F:\\1.txt");
		  BufferedReader in = new BufferedReader(file);
		  String newStr1 = in.readLine();
		  System.out.println(newStr1);
			StringTokenizer st = new StringTokenizer(newStr1,"\"");
		SMSModel newSms = new SMSModel(newStr1);
		System.out.println(newSms.getSend_Stamp()+"---");

		System.out.println(newSms.getByType("receive_Stamp"));
		System.out.println(newSms.getReceive_Stamp()+"---");
		
	
	  } catch (FileNotFoundException e) {
		    e.printStackTrace();
		}catch (IOException e) {
		    e.printStackTrace();
		}

	  }
}
