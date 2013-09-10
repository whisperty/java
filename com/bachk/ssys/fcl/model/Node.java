package com.bachk.ssys.fcl.model;

import java.util.ArrayList;
import java.lang.reflect.Method;

import com.bachk.ssys.fcl.service.*;

public class Node 
{
	//�������ݽڵ�
	private ArrayList<Node> inNodeArrayList = new ArrayList<Node>();
	//������
	private ArrayList<Data> outArrayList;
	//�ڵ����ͣ�������������
	private String type;
	//��������,��ǰ��link����������Ա���������������
	private ArrayList<String>inDataNameArrayList = new ArrayList<String>();
	
	//����Ĳ���
	private ArrayList<String>paraArrayList = new ArrayList<String>();
	//����������
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
	
	public Node(String type, String name)
	{
		this.type = type;
		this.paraArrayList.add(name);
		du = 0;
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
	
	//������
	public void calOut()
	{
    	try
    	{
    		Class typeClass = Class.forName("com.bachk.ssys.fcl.service."+type);
    	    Object typeObject = typeClass.newInstance();
    	    
    	    Class types[] =new Class[3];  
            types[0] = inNodeArrayList.getClass();//Class.forName("ArrayList<java.lang.String>");//�����Ĳ�����Ӧ�����String aa  
            types[1] = inDataNameArrayList.getClass();//Class.forName("ArrayList<java.lang.String>");
            types[2] = paraArrayList.getClass();//
            
            Method m = typeClass.getMethod("cal", types);//��̬����sayHello����  
            outArrayList = (ArrayList<Data>)m.invoke(typeObject, inNodeArrayList, inDataNameArrayList, paraArrayList);
            
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
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
	}
}