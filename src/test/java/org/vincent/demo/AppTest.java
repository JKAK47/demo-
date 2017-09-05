package org.vincent.demo;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	 
    public AppTest( String testName )
    {
        super( testName );
    }
    
    public void testclassload() {
    	ClassLoader classLoader=new ClassLoader() {
    		@Override
    		public Class<?> loadClass(String name) throws ClassNotFoundException {
    			System.out.println("加载类..."+name);
    			String className=name.substring(name.lastIndexOf(".")+1)+".class";
    			InputStream inputStream=getClass().getResourceAsStream(className);
    			if (inputStream==null) {
    				return super.loadClass(name);					
				}
    			try {
					System.out.println("自定义类加载器... "+name);
					int len=inputStream.available();
					byte[] values=new byte[len];
					inputStream.read(values);
					return defineClass(name, values, 0, values.length);
				} catch (Exception e) {
					e.printStackTrace();
				}
    			throw new ClassNotFoundException("类没找到");
				//return null;
    		}
		};
		try {
			Object object=classLoader.loadClass("org.vincent.demo.App").newInstance();
			System.out.println("类型： "+object.getClass());
			System.out.println(object instanceof App);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws ParseException 
     */
    public void testApp() throws ParseException
    {
    	DateFormat dateTimeformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	String strBeginDate = dateTimeformat.format(new Date());
    	System.out.println(strBeginDate);
    	 
    	//以上返回的是12小时制的时间
    	 
    	 dateTimeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 strBeginDate = dateTimeformat.format(new Date());
    	System.out.println(strBeginDate);
    	 
    	//以上返回的是24小时制的时间
    	 
    	//显示应该用下面的这个，因为12小时制的结果无法区分是上午还是下午
    	 
    	  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
    	  Date date = sdf.parse("20111212133712");
    	  System.out.println(date.getHours());
    	  System.out.println("DATE:"+date);
    	//这种是对的，字符串=》DATE是对的。但是DATE=>字符串是错的
    }
}
