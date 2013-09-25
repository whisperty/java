package operators;

import java.util.ArrayList;

import java.util.Date; 
import java.util.HashMap;
import java.util.Locale; 
import java.util.Map;
import java.io.IOException;
import java.text.DateFormat; 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 


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
		
		String []para = paraArrayList.get(1).split(" ");
		int []id = new int[para.length];
		ArrayList<String> line = in.get(0), data = new ArrayList<String>();
		
		for(int i = 0; i < para.length; i++)
		{
			data.add(para[i]);
			for(int j = 0; j < line.size(); j++)
				if(para[i].equals(line.get(j)))
				{
					id[i] = j;
					break;
				}
		}
		
		ans.add(data);
		for(int i = 1, size = para.length; i < in.size(); i++)
		{
			line = in.get(i);
			data = new ArrayList<String>();
			
			for(int j = 0; j < size; j++)
				data.add(line.get(id[j]));
			
			ans.add(data);
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws Exception
	{
		String [] s = "1 2 3 ".split(" ");
		for(int i = 0; i < s.length; i++)
				System.out.print("[" + s[i] + "]");
		//nodeMap.put(id, node);
		//Map<String, Node> nodeMap = new HashMap<String, Node>();
		//nodeMap.get(endFigureId);
	}
}
