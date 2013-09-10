package com.bachk.ssys.fcl.service;

public interface DataInputer<T> {
	//read data interface 

	public T readNextData();		//read next data
	
	public void closeInputer();		//stop read
	
	public boolean isClosed();			//judge if stopped
	
}
