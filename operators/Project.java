package operators;

import java.util.ArrayList;

import java.util.Date; 
import java.util.Locale; 
import java.io.IOException;
import java.text.DateFormat; 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 

import model.*;

public class Project {
	/*
	 * Project
		先实现简单的，针对三个需要分别设计三类Project（根据paraArrayList区分）
		输入：
		(IMSI,IMEI,event_type,Time_Stamp,Duration,start_lac,start_ci,end_lac,end_ci,sour_lac,sour_ci,dest_lac,dest_ci,cause,HLR,VLR,MSISDN,oppo_num,other_num,Res2)
		输出
		（1）GetTime（IMSI, Time_Stamp, Duration）
		（2）GetLacAndCi（IMSI,start ci，end ci, start lac , end lac）
		（3）GetPhoneNum(IMSI)
	 * */
	/*public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList)  throws ParseException
	{
		ArrayList<Data>ans = new ArrayList<Data>();
		
		ArrayList<Data> in = inNodeArrayList.get(0).getOut();
		
		String kind = paraArrayList.get(0);
		for(Data i : in)
		{
			String IMSI = i.get(0);
			String Time_Stamp = i.get(3);
			String Duration = i.get(4);
			String start_ci = i.get(6);
			String end_ci = i.get(8);
			String start_lac = i.get(5);
			String end_lac = i.get(7);
			
			Data data = new Data();
			if(kind.equals("GetTimeProject"))
			{
				data.add(IMSI);
				data.add(Time_Stamp);
				data.add(Duration);
			}
			else
				if(kind.equals("GetLacAndCiProject"))
				{
					data.add(IMSI);
					data.add(start_ci);
					data.add(end_ci);
					data.add(start_lac);
					data.add(end_lac);
				}
				else
					if(kind.equals("GetPhoneNumProject"))
					{
						data.add(IMSI);
					}
			
			ans.add(data);
		}
		
		return ans;
	}*/
	
	public ArrayList<ArrayList<String> > cal(ArrayList< ArrayList<ArrayList<String> > >inNode, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList) throws IOException
	{
		ArrayList<ArrayList<String> >ans = new ArrayList<ArrayList<String> >();
		ArrayList<ArrayList<String> > in = inNode.get(0);
		
		String kind = paraArrayList.get(0);
		for(ArrayList<String> i : in)
		{
			String IMSI = i.get(0);
			String Time_Stamp = i.get(3);
			String Duration = i.get(4);
			String start_ci = i.get(6);
			String end_ci = i.get(8);
			String start_lac = i.get(5);
			String end_lac = i.get(7);
			
			ArrayList<String> data = new ArrayList<String>();
			if(kind.equals("GetTimeProject"))
			{
				data.add(IMSI);
				data.add(Time_Stamp);
				data.add(Duration);
			}
			else
				if(kind.equals("GetLacAndCiProject"))
				{
					data.add(IMSI);
					data.add(start_ci);
					data.add(end_ci);
					data.add(start_lac);
					data.add(end_lac);
				}
				else
					if(kind.equals("GetPhoneNumProject"))
					{
						data.add(IMSI);
					}
			
			ans.add(data);
		}
		
		return ans;
	}
}
