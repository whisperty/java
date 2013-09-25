package com.bachk.ssys.fcl.service;

//import gg.JarUtil;

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
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;


//先加入dom4j.jar包 
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.bachk.ssys.fcl.model.SMSModel;
import com.bachk.ssys.fcl.model.SelectItem;
import model.*;

@Service
@RemotingDestination
public class Network 
{
	private ArrayList<Node> nodeArrayList = new ArrayList<Node>();
	
	@RemotingInclude
	public void init(String xmlNetwork)
	{
		 System.out.println("fsafdsafdsadfsaaaaaaaaaaaaaaasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		 //JarUtil.executeJarClass("file:\\G:\\users.jar", "users.TT", "cal", "454");
		 //JarUtil.executeJarClass(Conf.usersOperationJarRoot + "\\users.jar", "users.TT", "cal", "454");
		 //JarUtil.executeJarClass(Conf.operatorsJarRoot + "\\operators.jar", "operators.TT", "cal", "454");
		 //debug();
		/* Node node = new Node("DataStream");
		 
		// Debug d = new Debug("DataStream");
		 //d.calOut();
		 //d.print();
		 ArrayList< ArrayList< ArrayList<String> > > in = new ArrayList< ArrayList< ArrayList<String> > >();
		 ArrayList<String>name = new ArrayList<String>();
		 ArrayList<String>para = new ArrayList<String>();
		 //node.outArrayList = JarUtil.executeJarClass(node.type, node.inNodeArrayList, node.inDataNameArrayList, node.paraArrayList);
		 ArrayList< ArrayList<String> > outArrayList = (ArrayList< ArrayList<String> >)JarUtil.executeJarClass(node.type, in, name, para);
		 //node.calOut();
		 ArrayList<Data>dataList = new ArrayList<Data>();
		 for(int i = 0; i < outArrayList.size(); i++)
			 dataList.add(new Data(outArrayList.get(i)));
		 node.outArrayList = dataList;
		 
		 node.calOut();
		 node.print();
		 System.out.println("pppppppppppppppppppdfsadfsa");*/
		 
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
		 for(int i = 0; i < nodeArrayList.size(); i++)
			 nodeArrayList.get(i).print();
		
		//for(int i = 0; i < 5; i++)
		//	nodeArrayList.get(i).calOut();
		 cal();
		 //for(int i = 0; i < nodeArrayList.size(); i++)
		//	nodeArrayList.get(i).print();
		 
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
	    	// 将字符串转为XML
	    	doc = DocumentHelper.parseText(xmlNetwork); 
	        // 获取根节点
	        Element rootElt = doc.getRootElement(); 
	        // 拿到根节点的名称
	        // System.out.println("根节点：" + rootElt.getName()); 

	        // 获取根节点下的子节点Figure
	        // 遍历Figure节点,获取Node节点
	        Iterator iter = rootElt.elementIterator("Figure"); 
	        while (iter.hasNext()) 
	        {
	        	Element element = (Element) iter.next();
	        	
	        	String type = element.attributeValue("type");
	        	String id = element.attributeValue("ID");
	        	
	        	if(type.equals("Link")) continue;
	        	System.out.println("type=["+type+"]");
	        	
	        	String name = element.attributeValue("figureName");
	        	Node node = new Node(type);
	        	if(type.equals("DataStream"))
	        	{
	        		node.addPara("srcFilename=");
	        		node.addPara(element.attributeValue("srcFilename"));
	        		//System.out.println("                     ------DataStream srcFileName=" + element.attributeValue("srcFileName"));
	        	}
	        	else
	        		if(type.equals("Project"))
	        		{
	        			node.addPara("attributesName=");
	        			node.addPara(element.attributeValue("attributesName"));
	        		}
	        		else
	        			if(type.endsWith("Select"))
	        			{
	        				node.addPara("conditionExpr=");
	        				node.addPara(element.attributeValue("conditionExpr"));
	        			}
	        	
	        	nodeMap.put(id, node);
	        	nodeArrayList.add(node);
	        }
	        
	        // 获取根节点下的子节点Figure
	        // 遍历Figure节点,获取Node节点
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
		        	String figureName = element.attributeValue("figureName");
		        	nodeMap.get(endFigureId).addInNode(nodeMap.get(startFigureId), figureName);
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
