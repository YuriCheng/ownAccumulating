package org.yona.reflection;

import java.awt.Button;
import java.lang.reflect.Method;
import java.util.Hashtable;
public class ReflectionTest {
	
	/**
	 * Class ��getName()��������
	 * @throws ClassNotFoundException
	 */
	public void getNameTest() throws ClassNotFoundException{
		System.out.println("=================begin getNameTest===============");
		String name = "Yona";
		Class cls = name.getClass();
		System.out.println("String ����: " +cls.getName());
		
		Button btn = new Button();
		Class btnClass = btn.getClass();
		System.out.println("Button ����: " + btnClass.getName());
		Class superBtnClass = btnClass.getSuperclass();
		System.out.println("Button�ĸ�����: " + superBtnClass.getName());
		
		Class clsTest = Class.forName("java.awt.Button");
		System.out.println("clsTest name: " + clsTest.getName());
        System.out.println("===========end getNameTest============");
	}
	
	/**
	 * Class��getMethod()��������
	 * @throws Exception
	 */
	public void getMethodTest() throws Exception{
		System.out.println("===========begin getMethodTest==========");
		
		Class cls = Class.forName("org.yona.reflection.ReflectionTest");
		Class[] ptypes = new Class[2];
		ptypes[0] = Class.forName("java.lang.String");
		ptypes[1] = Class.forName("java.util.Hashtable");
		
		//��ȡ��Ӧ������,���뷽����,�Լ�����������,����method
		Method method = cls.getMethod("testMethod", ptypes);
		
		Object[] args = new Object[2];
		args[0] = "hello, my dear";
		
		Hashtable ht = new Hashtable();
		ht.put("name", "Yona");
		args[1] = ht;
		//ִ��method������������Object�������Ӧ����ֵ
		String returnStr = (String) method.invoke(new ReflectionTest(), args);
		System.out.println("returnStr= " + returnStr);
        System.out.println("===========end getMethodTest==========");
	}
	
	public String testMethod(String str, Hashtable ht){
		String returnStr = "����ֵ";
		System.out.println("����testMethod()��������");
		System.out.println("str= " + str);
		System.out.println("����= " + (String)ht.get("name"));
		System.out.println("����testMethod()��������");
		return returnStr; 
	}
	
	public static void main(String[] args) throws Exception {
		ReflectionTest reflection = new ReflectionTest();
		reflection.getNameTest();
		System.err.println(" ");
		
		reflection.getMethodTest();
	}
}
