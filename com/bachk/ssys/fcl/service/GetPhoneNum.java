package com.bachk.ssys.fcl.service;

import java.util.ArrayList;

import com.bachk.ssys.fcl.model.Data;
import com.bachk.ssys.fcl.model.Node;

public class GetPhoneNum {

	/*
	 * GetPhoneNum
	      ��ȡ�绰���룬������IMSI�����IMSI,�ֻ����룩
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
