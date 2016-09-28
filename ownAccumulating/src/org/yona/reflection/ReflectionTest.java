package org.yona.reflection;

import java.awt.Button;
import java.lang.reflect.Method;
import java.util.Hashtable;
public class ReflectionTest {
	
	/**
	 * Class 的getName()方法测试
	 * @throws ClassNotFoundException
	 */
	public void getNameTest() throws ClassNotFoundException{
		System.out.println("=================begin getNameTest===============");
		String name = "Yona";
		Class cls = name.getClass();
		System.out.println("String 类名: " +cls.getName());
		
		Button btn = new Button();
		Class btnClass = btn.getClass();
		System.out.println("Button 类名: " + btnClass.getName());
		Class superBtnClass = btnClass.getSuperclass();
		System.out.println("Button的父类名: " + superBtnClass.getName());
		
		Class clsTest = Class.forName("java.awt.Button");
		System.out.println("clsTest name: " + clsTest.getName());
        System.out.println("===========end getNameTest============");
	}
	
	/**
	 * Class的getMethod()方法测试
	 * @throws Exception
	 */
	public void getMethodTest() throws Exception{
		System.out.println("===========begin getMethodTest==========");
		
		Class cls = Class.forName("org.yona.reflection.ReflectionTest");
		Class[] ptypes = new Class[2];
		ptypes[0] = Class.forName("java.lang.String");
		ptypes[1] = Class.forName("java.util.Hashtable");
		
		//获取相应的类名,传入方法名,以及参数的类名,构造method
		Method method = cls.getMethod("testMethod", ptypes);
		
		Object[] args = new Object[2];
		args[0] = "hello, my dear";
		
		Hashtable ht = new Hashtable();
		ht.put("name", "Yona");
		args[1] = ht;
		//执行method方法，参数：Object对象和相应参数值
		String returnStr = (String) method.invoke(new ReflectionTest(), args);
		System.out.println("returnStr= " + returnStr);
        System.out.println("===========end getMethodTest==========");
	}
	
	public String testMethod(String str, Hashtable ht){
		String returnStr = "返回值";
		System.out.println("测试testMethod()方法调用");
		System.out.println("str= " + str);
		System.out.println("名字= " + (String)ht.get("name"));
		System.out.println("结束testMethod()方法调用");
		return returnStr; 
	}
	
	public static void main(String[] args) throws Exception {
		ReflectionTest reflection = new ReflectionTest();
		reflection.getNameTest();
		System.err.println(" ");
		
		reflection.getMethodTest();
	}
}
