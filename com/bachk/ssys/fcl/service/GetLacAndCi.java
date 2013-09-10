package com.bachk.ssys.fcl.service;

import java.util.ArrayList;


import com.bachk.ssys.fcl.model.Data;
import com.bachk.ssys.fcl.model.Node;

public class GetLacAndCi {

	/*
	 * GetLacAndCi
		����IMSI,start ci��end ci, start lac , end lac�������IMSI,��ʱ���ѡȡ����һ��ֵ,ȡstart_ci
	 * */
	public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList)
	{
		ArrayList<Data>ans = new ArrayList<Data>();
		
		ArrayList<Data> in = inNodeArrayList.get(0).getOut();
		for(Data i : in)
		{
			String IMSI = i.get(0);
			String t = i.get(1);
			
			Data data = new Data();
			data.add(IMSI);
			data.add(t);
			
			ans.add(data);
		}
		
		return ans;
	}
}
