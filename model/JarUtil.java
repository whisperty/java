package model;


import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

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
	
	public static Object executeJarClass(String type, String jarFilename, Object... args)
	{
		Object outArrayList = null;
		try
		{
			Class typeClass;
			
			try
			{
				typeClass = Class.forName("operators."+type);
				//typeClass = JarUtil.findClass("file:\\" + Conf.operatorsJarRoot + "\\operators.jar", "operators." + type);
			}
			catch(Exception e)
			{
				//typeClass = Class.forName("users."+type);
				//replaceFirst(" *$", "");
				jarFilename = jarFilename.replace(".jar", "");
				try
				{
					typeClass = JarUtil.findClass("file:\\" + Conf.usersOperatorsJarRoot + "\\" + jarFilename + ".jar", type);
				}
				catch(Exception ee)
				{
					typeClass = JarUtil.findClass("file:\\" + Conf.usersOperatorsJarRoot + "\\" + jarFilename + ".jar", jarFilename+"."+type);
				}
			}
			
			//typeClass = JarUtil.findClass(Conf.usersOperationJarRoot + "\\users.jar", "users." + type);
			
			Object typeObject = typeClass.newInstance();
		    
		    Class types[] =new Class[3];  
	        types[0] = args[0].getClass();//Class.forName("ArrayList<java.lang.String>");//方法的参数对应下面的String aa  
	        types[1] = args[1].getClass();//Class.forName("ArrayList<java.lang.String>");
	        types[2] = args[2].getClass();//
	        
	        Method m = typeClass.getMethod("cal", types);//动态调用sayHello方法  
	        outArrayList = (ArrayList<Data>)m.invoke(typeObject, args);
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return outArrayList;
	}
}
