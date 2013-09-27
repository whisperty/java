package operators;

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.ArrayList;


public class End {
	/*public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList) throws IOException
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
	}*/
	
	public ArrayList<ArrayList<String> > cal(ArrayList< ArrayList<ArrayList<String> > >inNode, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList) throws IOException
	{
		ArrayList<ArrayList<String> >ans;
	
		ArrayList<ArrayList<String> > in = inNode.get(0);
		
		ans = in;
		FileWriter fw = new FileWriter(Conf.endResultFileRoot);//创建FileWriter对象，用来写入字符流
        BufferedWriter bw = new BufferedWriter(fw);    //将缓冲对文件的输出
        
        for(int i = 0; i < in.size(); i++)
        {
        	ArrayList<String> ii = in.get(i);
        	String tmp = "";
        	for(int j = 0; j < ii.size(); j++)
        	{
        		if(j != 0)	tmp += "\t";
        		tmp += ii.get(j);
        	}
        	
        	bw.write(tmp);
        	bw.newLine();
        }
        
        bw.flush();
        bw.close();
        
		return ans;
	}
}
