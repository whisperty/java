package users;

import java.io.IOException;
import java.util.ArrayList;


public class GetPhoneNum {

	/*
	 * GetPhoneNum
	      提取电话号码，（输入IMSI，输出IMSI,手机号码）
	 */
	/*public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList)
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
	*/
	
	public ArrayList<ArrayList<String> > cal(ArrayList< ArrayList<ArrayList<String> > >inNode, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList) throws IOException
	{
		ArrayList<ArrayList<String> >ans = new ArrayList<ArrayList<String> >();
		
		ArrayList<ArrayList<String> > in = inNode.get(0);
		for(ArrayList<String> i : in)
		{
			String IMSI = i.get(0);
			
			ArrayList<String> data = new ArrayList<String>();
			data.add(IMSI);
			data.add("phoneNumber");
			
			ans.add(data);
		}
		
		return ans;
	}
}
