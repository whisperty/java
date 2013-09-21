package operators;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


import model.*;

public class Join {
	
	/*
	 * Join
		�����������ݽڵ㣬��ÿ�����ݽڵ�ĵ�һ����Ϊ��������join
	 * */
	/*public ArrayList<Data> cal(ArrayList<Node>inNodeArrayList, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList)  throws ParseException
	{
		ArrayList<Data>ans = new ArrayList<Data>();
		
		ArrayList<Data> in0 = inNodeArrayList.get(0).getOut();
		ArrayList<Data> in1 = inNodeArrayList.get(1).getOut();
		
		for(int i = 0; i < in0.size(); i++)
		{
			Data data0 = in0.get(i);
			Data data1 = in1.get(i);
			Data data = new Data();
			
			if(data0.get(0).equals(data1.get(0)))
			{
				for(int k = 0; k < data0.size(); k++)
					data.add(data0.get(k));
				
				for(int k = 1; k < data1.size(); k++)
					data.add(data1.get(k));
				
				ans.add(data);
				continue;
			}
			
			for(int j = 0; j < in1.size(); j++)
			{
				data1 = in1.get(j);
				if(data0.get(0).equals(data1.get(0)))
				{
					for(int k = 0; k < data0.size(); k++)
						data.add(data0.get(k));
					
					for(int k = 1; k < data1.size(); k++)
						data.add(data1.get(k));
					
					ans.add(data);
					break;
				}
			}
		}
		
		return ans;
	}*/
	
	public ArrayList<ArrayList<String> > cal(ArrayList< ArrayList<ArrayList<String> > >in, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList) throws IOException
	{
		ArrayList<ArrayList<String> >ans = new ArrayList<ArrayList<String> >();
		
		ArrayList<ArrayList<String> > in0 = in.get(0);
		ArrayList<ArrayList<String> > in1 = in.get(1);
		
		for(int i = 0; i < in0.size(); i++)
		{
			ArrayList<String> data0 = in0.get(i);
			ArrayList<String> data1 = in1.get(i);
			ArrayList<String> data = new ArrayList<String>();
			
			if(data0.get(0).equals(data1.get(0)))
			{
				for(int k = 0; k < data0.size(); k++)
					data.add(data0.get(k));
				
				for(int k = 1; k < data1.size(); k++)
					data.add(data1.get(k));
				
				ans.add(data);
				continue;
			}
			
			for(int j = 0; j < in1.size(); j++)
			{
				data1 = in1.get(j);
				if(data0.get(0).equals(data1.get(0)))
				{
					for(int k = 0; k < data0.size(); k++)
						data.add(data0.get(k));
					
					for(int k = 1; k < data1.size(); k++)
						data.add(data1.get(k));
					
					ans.add(data);
					break;
				}
			}
		}
		
		return ans;
	}
	
}
