package com.bachk.ssys.fcl.service;

import java.util.ArrayList;

import java.util.Date; 
import java.util.Locale; 
import java.text.DateFormat; 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 

import com.bachk.ssys.fcl.model.Data;
import com.bachk.ssys.fcl.model.Node;

public class GetTime {

	/*
	 * GetTime
		����ʱ�����ڵ�ʱ����Ϣ�����룺��������ʱ����ؼ���
		IMSI, Time_Stamp, Duration(��λ��)
		�����IMSI,���ڣ���ʼʱ�䣬����ʱ�䣩
	 * */
	public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList)  throws ParseException
	{
		ArrayList<Data>ans = new ArrayList<Data>();
		
		ArrayList<Data> in = inNodeArrayList.get(0).getOut();
		for(Data i : in)
		{
			String IMSI = i.get(0);
			String TimeStamp = i.get(1);
			String Duration = i.get(2);
			
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
			Date date = df.parse(TimeStamp);
			Date endDate = new Date(date.getTime() + (long)Long.parseLong(Duration) * 1000);
			
			Data data = new Data();
			data.add(IMSI);
			data.add(df2.format(date));
			data.add(df.format(date));
			data.add(df.format(endDate));
			
			ans.add(data);
		}
		
		return ans;
	}
}
