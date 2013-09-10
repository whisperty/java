package com.bachk.ssys.fcl.service;

import java.util.ArrayList;

import com.bachk.ssys.fcl.model.Data;
import com.bachk.ssys.fcl.model.Node;

public class GetPhoneNum {

	/*
	 * GetPhoneNum
	      提取电话号码，（输入IMSI，输出IMSI,手机号码）
	 */
	public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList)
	{
		ArrayList<Data>ans = new ArrayList<Data>();
		
		ArrayList<Data> in = inNodeArrayList.get(0).getOut();
		for(Data i : in)
		{
			String IMSI = i.get(0);
			
			Data data = new Data();
			data.add(IMSI);
			data.add("phoneNumber");
			
			ans.add(data);
		}
		
		return ans;
	}
}
