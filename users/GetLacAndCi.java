package users;

import java.io.IOException;
import java.util.ArrayList;


import model.*;

public class GetLacAndCi {

	/*
	 * GetLacAndCi
		输入IMSI,start ci，end ci, start lac , end lac，输出：IMSI,暂时随便选取其中一个值,取start_ci
	 * */
	/*public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList)
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
	}*/
	
	public ArrayList<ArrayList<String> > cal(ArrayList< ArrayList<ArrayList<String> > >inNode, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList) throws IOException
	{
		ArrayList<ArrayList<String> >ans = new ArrayList<ArrayList<String> >();
		
		ArrayList<ArrayList<String> > in = inNode.get(0);
		for(ArrayList<String> i : in)
		{
			String IMSI = i.get(0);
			String t = i.get(1);
			
			ArrayList<String> data = new ArrayList<String>();
			data.add(IMSI);
			data.add(t);
			
			ans.add(data);
		}
		
		return ans;
	}
}
