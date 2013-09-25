package users;

import java.io.IOException;
import java.util.ArrayList;


public class GetLacAndCi {


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
	
	/*
	 * GetLacAndCi
		输入IMSI,start ci，end ci, start lac , end lac，输出：IMSI,暂时随便选取其中一个值,取start_ci
	 * */
	public ArrayList<ArrayList<String> > cal(ArrayList< ArrayList<ArrayList<String> > >inNode, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList) throws IOException
	{
		ArrayList<ArrayList<String> >ans = new ArrayList<ArrayList<String> >();
		
		ArrayList<ArrayList<String> > in = inNode.get(0);
		
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> i = in.get(0);
		data.add(i.get(0));
		data.add(i.get(1));
		ans.add(data);
		
		for(int j = 1; j <  in.size(); j++)
		{
		    i = in.get(j);
			String IMSI = i.get(0);
			String t = i.get(1);
			
			data = new ArrayList<String>();
			data.add(IMSI);
			data.add(t);
			
			ans.add(data);
		}
		
		return ans;
	}
}
