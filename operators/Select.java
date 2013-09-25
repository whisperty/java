package operators;

import java.io.IOException;
import java.util.ArrayList;

public class Select {

	public ArrayList<ArrayList<String> > cal(ArrayList< ArrayList<ArrayList<String> > >inNode, ArrayList<String>inNodeNameArrayList, ArrayList<String> paraArrayList) throws IOException
	{
		ArrayList<ArrayList<String> >ans = new ArrayList<ArrayList<String> >();
		
		String [] para = paraArrayList.get(1).split(" ");
		ArrayList<ArrayList<String>> in = inNode.get(0);
		ArrayList<String> line = in.get(0);		
		int id = 0;
		for(int i = 0; i < line.size(); i++)
			if(line.get(i).equals(para[0]))
			{
				id = i;
				break;
			}
		
		ans.add(line);
		for(int i = 1; i < in.size(); i++)
		{
			line = in.get(i);
			if(compare(line.get(id), para[1], para[2]))
				ans.add(line);
		}
		
		return ans;
	}
	
	private boolean compare(String a, String op, String b)
	{
		if(op.equals("=="))
			return a.equals(b);
		else
		if(op.equals("!="))
			return a.equals(b) == false;
		else
		if(op.equals(">"))
			return Double.parseDouble(a) > Double.parseDouble(b);
		else
		if(op.equals("<"))
			return Double.parseDouble(a) < Double.parseDouble(b);
			
		return false;
	}
	
	public static void main(String[] args)
	{
		
	}
}
