package model;

import java.util.*;

public class Data {
	private ArrayList<String> valueArrayList;
	
	public Data()
	{
		valueArrayList = new ArrayList<String>();
	}
	
	public Data(ArrayList<String> valueArrayList2)
	{
		valueArrayList = valueArrayList2;
	}
	
	public String get(int index)
	{
		return valueArrayList.get(index);
	}
	
	public void add(String value)
	{
		valueArrayList.add(value);
	}
	
	public void set(int index, String value)
	{
		valueArrayList.set(index, value);
	}
	
	public int size()
	{
		return valueArrayList.size();
	}
	
	public ArrayList<String> toArrayList()
	{
		return valueArrayList;
	}
	
	public void print()
	{
		for(int i = 0; i < valueArrayList.size(); i++)
		{
			if(i != 0)	System.out.print(" ");
			System.out.print(valueArrayList.get(i));
		}
		
		System.out.println("");
	}
}
