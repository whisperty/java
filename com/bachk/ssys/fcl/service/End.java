package com.bachk.ssys.fcl.service;

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.ArrayList;


import com.bachk.ssys.fcl.model.Data;
import com.bachk.ssys.fcl.model.Node;

public class End {
	public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList) throws IOException
	{
		ArrayList<Data>ans = new ArrayList<Data>();
		ArrayList<Data> in = inNodeArrayList.get(0).getOut();
		FileWriter fw = new FileWriter("F://Stream//myresult.txt");//创建FileWriter对象，用来写入字符流
        BufferedWriter bw = new BufferedWriter(fw);    //将缓冲对文件的输出
        
        for(Data i : in)
        {
        	String tmp = "";
        	for(int j = 0; j < i.size(); j++)
        	{
        		if(j != 0)	tmp += "\t";
        		tmp += i.get(j);
        	}
        	
        	bw.write(tmp);
        	bw.newLine();
        }
        
        bw.flush();
        bw.close();
		return ans;
	}
}
