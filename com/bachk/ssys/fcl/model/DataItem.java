package com.bachk.ssys.fcl.model;

public class DataItem {

	private double value;			//record the data value
	private double time;			//record the time when the data is read (time sequence)
	
	public DataItem(double value, double time)
	{
		this.value = value;
		this.time = time;
	}
	
	public DataItem(DataItem d)
	{
		value = d.value;
		time = d.time;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public double getTime()
	{
		return time;
	}
	
	public void setValue(double value)
	{
		this.value = value;
	}
	
	public void setTime(double time)
	{
		this.time = time;
	}
	
	public void setDataItem(DataItem d)
	{
		value = d.value;
		time = d.time;
	}
	
	public String toString()
	{
		return "[time=" + time+ ",value=" + value + "]"; 
	}
}
