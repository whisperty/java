package com.bachk.ssys.fcl.service;

import java.text.ParseException;
import java.util.ArrayList;


import com.bachk.ssys.fcl.model.Data;
import com.bachk.ssys.fcl.model.Node;

public class Join {
	
	/*
	 * Join
		两个输入数据节点，以每个数据节点的第一列作为主键进行join
	 * */
	public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList)  throws ParseException
	{
		ArrayList<Data>ans = new ArrayList<Data>();
		
		ArrayList<Data> in0 = inNodeArrayList.get(0).getOut();
		ArrayList<Data> in1 = inNodeArrayList.get(1).getOut();
		
		for(int i = 0; i < in0.size(); i++)
		{
			Data data0 = in0.get(i);
			Data data1 = in1.get(i);
			Data data = new Data();
			
			if(data0.get(0).equals(data1.get(0)))
			{
				for(int k = 0; k < data0.size(); k++)
					data.add(data0.get(k));
				
				for(int k = 1; k < data1.size(); k++)
					data.add(data1.get(k));
				
				ans.add(data);
				continue;
			}
			
			for(int j = 0; j < in1.size(); j++)
			{
				data1 = in1.get(j);
				if(data0.get(0).equals(data1.get(0)))
				{
					for(int k = 0; k < data0.size(); k++)
						data.add(data0.get(k));
					
					for(int k = 1; k < data1.size(); k++)
						data.add(data1.get(k));
					
					ans.add(data);
					break;
				}
			}
		}
		
		return ans;
	}
}
