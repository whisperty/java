package com.bachk.ssys.fcl.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;


//�ȼ���dom4j.jar�� 
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.bachk.ssys.fcl.model.SMSModel;
import com.bachk.ssys.fcl.model.SelectItem;
import com.bachk.ssys.fcl.model.Node;
@Service
@RemotingDestination
public class Network 
{
	private ArrayList<Node> nodeArrayList = new ArrayList<Node>();
	
	@RemotingInclude
	public void init(String xmlNetwork)
	{
		 System.out.println("fsafdsafdsadfsaaaaaaaaaaaaaaasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		 File f = new File("F:\\Stream\\log.txt");
		 BufferedWriter output;
		 
		 try
		 {
			 output = new BufferedWriter(new FileWriter(f));
			 output.write(xmlNetwork);
			 output.close();
		 }
		 
		 catch(Exception e)
		 {
			 e.printStackTrace();  
		 }
		 
		 getNetwork(xmlNetwork);
		 topo();
		 //for(int i = 0; i < nodeArrayList.size(); i++)
			// nodeArrayList.get(i).print();
		
		//for(int i = 0; i < 5; i++)
		//	nodeArrayList.get(i).calOut();
		 cal();
		 //for(int i = 0; i < nodeArrayList.size(); i++)
			// nodeArrayList.get(i).print();
		 
		//System.out.println(nodeArrayList.size());
	}
	
	void cal()
	{
		for(int i = 0; i < nodeArrayList.size(); i++)
			nodeArrayList.get(i).calOut();
	}
	
	void getNetwork(String xmlNetwork)
	{
		Document doc = null;
		Map<String, Node> nodeMap = new HashMap<String, Node>();
		
	    try 
	    {
	    	// ���ַ���תΪXML
	    	doc = DocumentHelper.parseText(xmlNetwork); 
	        // ��ȡ���ڵ�
	        Element rootElt = doc.getRootElement(); 
	        // �õ����ڵ������
	        // System.out.println("���ڵ㣺" + rootElt.getName()); 

	        // ��ȡ���ڵ��µ��ӽڵ�Figure
	        // ����Figure�ڵ�,��ȡNode�ڵ�
	        Iterator iter = rootElt.elementIterator("Figure"); 
	        while (iter.hasNext()) 
	        {
	        	Element element = (Element) iter.next();
	        	
	        	String type = element.attributeValue("type");
	        	String id = element.attributeValue("ID");
	        	
	        	if(type.equals("Link")) continue;
	        	System.out.println("type=["+type+"]");
	        	
	        	String name = element.attributeValue("figureName");
	        	Node node = new Node(type, name);
	        	nodeMap.put(id, node);
	        	nodeArrayList.add(node);
	        }
	        
	        // ��ȡ���ڵ��µ��ӽڵ�Figure
	        // ����Figure�ڵ�,��ȡNode�ڵ�
	        iter = rootElt.elementIterator("Figure"); 
	        while (iter.hasNext()) 
	        {
	        	Element element = (Element) iter.next();
	        	
	        	String type = element.attributeValue("type");

	        	if(type.equals("Link"))
	        	{
	        		System.out.println("type=["+type+"}");
		        	String startFigureId = element.attributeValue("startFigureId");
		        	String endFigureId = element.attributeValue("endFigureId");
		        	nodeMap.get(endFigureId).addInNode(nodeMap.get(startFigureId), "myNull");
		        	nodeMap.get(startFigureId).du++;
	        	}
	        }
	    }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
	
	void topo()
	{
		ArrayList<Node> tp = new ArrayList<Node>();
		for(Node i : nodeArrayList)
			if(i.du == 0)
				tp.add(i);
		
		for(int i = 0; i < tp.size(); i++)
			tp.get(i).cutLink(tp);
		
		nodeArrayList.clear();
		for(int i = tp.size() - 1; i >= 0; i--)
			nodeArrayList.add(tp.get(i));
	}
	
	public static void main(String[] args) throws Exception
	{
		String xml = "";
		String path = "F:\\Stream\\sig_data_network.xml";
		BufferedReader br=new BufferedReader(new FileReader(new File(path)));
		String record=null;
		while((record=br.readLine())!=null) {
		       //System.out.println(record);
		       xml = xml + "\n" + record;
		}	
		
		//System.out.println(xml);
		
		Network net = new Network();
		net.init(xml);
	}
}
