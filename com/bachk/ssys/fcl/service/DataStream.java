package com.bachk.ssys.fcl.service;

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.ArrayList;


import com.bachk.ssys.fcl.model.Data;
import com.bachk.ssys.fcl.model.Node;

public class DataStream {
	public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList) throws IOException
	{
		ArrayList<Data>ans = new ArrayList<Data>();
		
		//ArrayList<Data> in = inNodeArrayList.get(0).getOut();		
		File file = new File("F:\\Stream\\sig_data.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str = null;
		
		while((str = reader.readLine()) != null)
		{
			String[] strArray = str.split("\\t");
			Data data = new Data();
			
			for(int i = 0; i < strArray.length; i++)
			{
				String tmp = strArray[i].replaceFirst("^ *", "");
				String tp = tmp.replaceFirst(" *$", "");
				
				data.add(tp);
				
				//System.out.print("{"+tp+"}");
			}
			
			//System.out.println("");
			
			ans.add(data);
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws Exception
	{
		DataStream tmp = new DataStream();
		ArrayList<Node> a = new ArrayList<Node>();
		ArrayList<String>b = new ArrayList<String>();
		
		tmp.cal(a, b,  b);
		System.out.println("asdfasfd");
	}
}
