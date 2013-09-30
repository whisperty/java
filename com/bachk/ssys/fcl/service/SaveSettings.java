package com.bachk.ssys.fcl.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import model.Conf;

import org.dom4j.*;
import org.dom4j.io.*;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;

@Service
@RemotingDestination
public class SaveSettings {
	
	
	@RemotingInclude
	public void savePatterns(String patterns) throws IOException, DocumentException{
		String patternsFilename = Conf.settingsFileRoot+"\\Patterns.xml";
		 File file=new File(patternsFilename);
         if(!file.exists())
             file.createNewFile();
         Document doc = DocumentHelper.parseText(patterns); 
         OutputFormat format = OutputFormat.createPrettyPrint();
         format.setEncoding("GB2312");
         XMLWriter writer = new XMLWriter(new FileWriter(file), format);
         writer.write(doc);
//         System.out.println("write successfully");
         writer.close();
	}
	
	@RemotingInclude
	public void saveOperators(String operators) throws DocumentException, IOException
	{
		String patternsFilename = Conf.settingsFileRoot+"\\Operators.xml";
		 File file=new File(patternsFilename);
        if(!file.exists())
            file.createNewFile();
        Document doc = DocumentHelper.parseText(operators); 
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("GB2312");
        XMLWriter writer = new XMLWriter(new FileWriter(file), format);
        writer.write(doc);
        writer.close();
	}
	
}
