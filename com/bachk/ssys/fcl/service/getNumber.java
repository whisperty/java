package com.bachk.ssys.fcl.service;

import java.util.ArrayList;


import com.bachk.ssys.fcl.model.Data;
import com.bachk.ssys.fcl.model.Node;

public class getNumber 
{
	public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList)
	{
		ArrayList<Data>ans = new ArrayList<Data>();
		
		for(int i = 0; i < 2; i++)
		{
			Data d = new Data();
			for(int j = 0; j < 2; j++)
			{
				d.add(inNodeArrayList.get(0).getOut().get(i).get(j));
			}
			
			for(int j = 0; j < 2; j++)
			{
				d.add(inNodeArrayList.get(1).getOut().get(i).get(j));
			}
			
			ans.add(d);
		}
		
		System.out.println("getNumber number number number number");
		return ans;
	}
	
	public static void main(String[] args) throws Exception
	{
		
	}
}
