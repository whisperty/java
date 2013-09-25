package users;

import java.util.ArrayList;

import java.util.Date; 
import java.util.Locale; 
import java.io.IOException;
import java.text.DateFormat; 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 


public class GetTime {

	/*
	 * GetTime
包括时间日期等时间信息（输入：信令数据时间相关几栏
IMSI, Time_Stamp, Duration(单位秒)
输出：IMSI,日期date，开始时间start_time，结束时间end_time）
	 * */
	/*public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList)  throws ParseException
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
	}*/
	
	public ArrayList<ArrayList<String> > cal(ArrayList< ArrayList<ArrayList<String> > >inNode, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList) throws Exception
	{
		ArrayList<ArrayList<String> >ans = new ArrayList<ArrayList<String> >();
		
		ArrayList<ArrayList<String> > in = inNode.get(0);
		ArrayList<String> i = in.get(0);
		ArrayList<String> data = new ArrayList<String>();
		data.add(i.get(0));
		data.add("date");
		data.add("start_time");
		data.add("end_time");
		
		ans.add(data);
		
		for(int j = 1; j < in.size(); j++)
		{
			i = in.get(j);
			String IMSI = i.get(0);
			String TimeStamp = i.get(1);
			String Duration = i.get(2);
			
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
			Date date = df.parse(TimeStamp);
			Date endDate = new Date(date.getTime() + (long)Long.parseLong(Duration) * 1000);
			
			data = new ArrayList<String>();
			data.add(IMSI);
			data.add(df2.format(date));
			data.add(df.format(date));
			data.add(df.format(endDate));
			
			ans.add(data);
		}
		
		return ans;
	}
}
