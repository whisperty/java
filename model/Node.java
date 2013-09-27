package model;


import java.util.ArrayList;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import java.net.*;
import java.util.ArrayList;
import java.util.jar.*;
import java.lang.*;
import java.lang.reflect.*;

public class Node 
{
	//输入数据节点
	private ArrayList<Node> inNodeArrayList = new ArrayList<Node>();
	//计算结果
	private ArrayList<Data> outArrayList;
	//节点类型，包括操作类型
	private String type;
	//参数描述,由前端link的描述获得以便于区分输入数据
	private ArrayList<String>inDataNameArrayList = new ArrayList<String>();
	
	//运算的参数
	private ArrayList<String>paraArrayList = new ArrayList<String>();
	//拓扑排序用
	public int du;
	
	public Node()
	{
		du = 0;
	}
	
	public Node(String type)
	{
		this.type = type;
		du = 0;
	}
	
	/*public Node(String type, String name)
	{
		this.type = type;
		this.paraArrayList.add(name);
		du = 0;
	}*/
	
	public void addPara(String para)
	{
		paraArrayList.add(para);
	}
	
	public void cutLink(ArrayList<Node> result)
	{
		for(Node i : inNodeArrayList)
		{
			i.du--;
			if(i.du == 0)
				result.add(i);
		}
	}
	
	public void print()
	{
		if(paraArrayList.size()>0)
			System.out.print("name="+ paraArrayList.get(0)+" ");
		System.out.println("type = " + type + ", inSize = " + inNodeArrayList.size());
		
		if(outArrayList != null)
		{
			for(Data i : outArrayList)
				i.print();
		}
	}
	
	public void addInNode(Node inNode, String inDataName)
	{
		inNodeArrayList.add(inNode);
		inDataNameArrayList.add(inDataName);
	}
	
	public Node getInNode(int index)
	{
		return inNodeArrayList.get(index);
	}
	
	public ArrayList<Data> getOut()
	{
		return outArrayList;
	}
	
	public ArrayList<ArrayList<String> > outArrayListToArrayList()
	{
		ArrayList<ArrayList<String> > ans = new ArrayList<ArrayList<String> >();
		for(int i = 0; i < outArrayList.size(); i++)
			ans.add(outArrayList.get(i).toArrayList());
		
		return ans;
	}
	
	public ArrayList<String>  getOutDataArrayList()
	{
		ArrayList<String> ans = new ArrayList<String>();
		
		int size = outArrayList.get(0).size();
		for(int i = 1; i < outArrayList.size(); i++)
		{
			ArrayList<String> line = outArrayList.get(i).toArrayList();
			
			if(line.size() != size)
				System.out.println("erroreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" + line.size() + " "+ size);
			for(int j = 0; j < line.size(); j++)
				ans.add(line.get(j));
		}
		
		return ans;
	}
	
	public ArrayList<ArrayList<ArrayList<String> > > inNodeArrayListToArrayList()
	{
		ArrayList<ArrayList<ArrayList<String> > >ans = new ArrayList<ArrayList<ArrayList<String> > >();
		
		for(int i = 0; i < inNodeArrayList.size(); i++)
			ans.add(inNodeArrayList.get(i).outArrayListToArrayList());
		
		return ans;
	}
	
	public ArrayList<Data> toDataArrayList(ArrayList<ArrayList<String> > in)
	{
		ArrayList<Data> ans = new ArrayList<Data>();
		
		for(int i = 0; i < in.size(); i++)
			ans.add(new Data(in.get(i)));
		
		return ans;
	}
	
	//计算结果
	public void calOut()
	{
		String tmp = "";
		if(paraArrayList != null && paraArrayList.size() >= 2)
			tmp = paraArrayList.get(1);
		
		//tmp = "users.jar";
		outArrayList = toDataArrayList((ArrayList<ArrayList<String> >)JarUtil.executeJarClass(type, tmp, this.inNodeArrayListToArrayList(), inDataNameArrayList, paraArrayList));
		
		/*
    	try
    	{
    		Class typeClass;
    		
    		try
    		{
    			//typeClass = Class.forName("com.bachk.ssys.fcl.service."+type);
    			typeClass = JarUtil.findClass(Conf.operatorsJarRoot + "\\operators.jar", "operators." + type);
    		}
    		catch(Exception e)
    		{
    			typeClass = JarUtil.findClass(Conf.usersOperationJarRoot + "\\users.jar", "users." + type);
    		}
    		
    		//typeClass = JarUtil.findClass(Conf.usersOperationJarRoot + "\\users.jar", "users." + type);
    		
    		Object typeObject = typeClass.newInstance();
    	    
    	    Class types[] =new Class[3];  
            types[0] = inNodeArrayList.getClass();//Class.forName("ArrayList<java.lang.String>");//方法的参数对应下面的String aa  
            types[1] = inDataNameArrayList.getClass();//Class.forName("ArrayList<java.lang.String>");
            types[2] = paraArrayList.getClass();//
            
            Method m = typeClass.getMethod("cal", types);//动态调用sayHello方法  
            outArrayList = (ArrayList<Data>)m.invoke(typeObject, inNodeArrayList, inDataNameArrayList, paraArrayList);
            
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}*/
	}
	
	public static void main(String [] args) throws Exception
	{
		Data a = new Data(), b = new Data(), c = new Data(), d = new Data();
		a.add("a0");
		a.add("a1");
		b.add("b0");
		b.add("b1");
		c.add("c0");
		c.add("c1");
		d.add("d0");
		d.add("d1");
		
		Node e = new Node(), f = new Node(), g = new Node("getNumber");
		e.outArrayList = new ArrayList<Data>();
		e.outArrayList.add(a);
		e.outArrayList.add(b);
		f.outArrayList = new ArrayList<Data>();
		f.outArrayList.add(c);
		f.outArrayList.add(d);
		g.addInNode(e, "e");
		g.addInNode(f, "f");
		
		g.calOut();
		ArrayList<Data> out = g.outArrayList;
		for(int i = 0; i < out.size(); i++)
			out.get(i).print();
		
		System.out.println("size"+out.size());
		System.out.println("Node Test testTest testTest testTest testTest testTest testTest test");
		
    	/*try
    	{
    		Class typeClass = Class.forName("users.TT");
    	    Object typeObject = typeClass.newInstance();
    	    
    	    Class types[] =new Class[1];  
    	    types[0] = String.class;
    	    
            Method m = typeClass.getMethod("cal", types);//动态调用sayHello方法  
            m.invoke(typeObject, "asfd");
            
    	}
    	catch(Exception ee)
    	{
    		ee.printStackTrace();
    	}*/
    	
	}
}
