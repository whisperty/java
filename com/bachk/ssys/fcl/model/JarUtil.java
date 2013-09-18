package com.bachk.ssys.fcl.model;

import java.net.URL;
import java.net.URLClassLoader;

public class JarUtil extends URLClassLoader {
	public JarUtil(URL url) {
		super(new URL[] { url });
	}
	
	public static Class findClass(String jarPath, String classPath) throws Exception
	{
		URL url = new URL(jarPath);
		JarUtil t = new JarUtil(url);
		//Class typeClass = t.findClass("gg.TT");

		return  t.findClass(classPath);
	}
}
