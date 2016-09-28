package org.yona.reflection.spring;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {
	private  Map<String, Object> beanMap = new HashMap<String, Object>();
	
	public void init(String xml){
		try {
			//解析xml
			//读取指定位置的配置文件
			SAXReader reader = new SAXReader();
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			
			//从class目录下获取指定的xml文件
			InputStream ins = classLoader.getResourceAsStream(xml);
			Document doc = reader.read(ins);
			Element root = doc.getRootElement();
			Element foo;
			
			//遍历bean
			for(Iterator i= root.elementIterator("bean");i.hasNext();){
				 
				foo = (Element) i.next();
				
				//获取bean的属性id和class
				Attribute id = foo.attribute("id");
				Attribute cls = foo.attribute("class");
				
				//利用Java反射机制，通过class的名称获取Class对象
				 Class bean = Class.forName(cls.getText());
				 //获取对应的class信息
				 BeanInfo info = Introspector.getBeanInfo(bean);
				 //获取属性描述
				 PropertyDescriptor[] pd = info.getPropertyDescriptors();
				 
				 //设置值的方法
				 Method mSet = null;
				 
				 //创建一个对象
				 Object obj = bean.newInstance();
				 
				 //遍历该bean的property属性
				  for(Iterator ite = foo.elementIterator("property"); ite.hasNext();){
					  Element foo2 = (Element) ite.next();
					  //获取property的name属性
					  Attribute name = foo2.attribute("name");
					  String value = null;
					  for(Iterator ite1 = foo2.elementIterator("value");ite1.hasNext();){
						    
						  Element node = (Element) ite1.next();
						  value = node.getText();
						  break;
					  }
					  for(PropertyDescriptor pdtor : pd){
						  if(pdtor.getName().equalsIgnoreCase(name.getText())){
							  //Gets the method that should be used to write the property value.
							  //根据属性,返回该属性写方法的Method对象
							  mSet = pdtor.getWriteMethod();
							  
							  //利用Java的反射极致调用对象的某个set方法,并将值设置进去
							  //相当于调用set方法
							  mSet.invoke(obj, value);
						  }
					  }
				  }
				  
				//将对象放入beanMap中，其中key为id值，value为对象
				  beanMap.put(id.getText(), obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通过bean的id获取bean的对象
	 * @param beanName bean的id
	 * @return 返回对应的对象
	 */
	public Object getBean(String beanName){
		Object obj = beanMap.get(beanName);
		return obj;
	}
	
	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		factory.init("config.xml");
		JavaBean javaBean = (JavaBean) factory.getBean("javaBean");
		 System.out.println("userName=" + javaBean.getUserName());
         System.out.println("password=" + javaBean.getPassword());
	}
}
