package operators;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


public class Combine {
	
	/*
	 * Join
		两个输入数据节点，以每个数据节点的第一列作为主键进行join
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
		Integer i0 = Integer.valueOf(inNodeNameArrayList.get(0)), i1 = Integer.valueOf(inNodeNameArrayList.get(1));
		
		if(i0.compareTo(i1) > 0)
		{
			in0 = in.get(1);
			in1 = in.get(0);
		}
		
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> data0 = in0.get(0);
		ArrayList<String> data1 = in1.get(0);
		for(int i = 0; i < data0.size(); i++)
			data.add(data0.get(i));
		for(int i = 1; i < data1.size(); i++)
			data.add(data1.get(i));
		ans.add(data);
		
		for(int i = 1; i < in0.size(); i++)
		{
			data0 = in0.get(i);
			data1 = in1.get(i);
			data = new ArrayList<String>();
			
			if(data0.get(0).equals(data1.get(0)))
			{
				for(int k = 0; k < data0.size(); k++)
					data.add(data0.get(k));
				
				for(int k = 1; k < data1.size(); k++)
					data.add(data1.get(k));
				
				ans.add(data);
				continue;
			}
			
			for(int j = 1; j < in1.size(); j++)
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
