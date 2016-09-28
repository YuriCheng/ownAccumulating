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
			//����xml
			//��ȡָ��λ�õ������ļ�
			SAXReader reader = new SAXReader();
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			
			//��classĿ¼�»�ȡָ����xml�ļ�
			InputStream ins = classLoader.getResourceAsStream(xml);
			Document doc = reader.read(ins);
			Element root = doc.getRootElement();
			Element foo;
			
			//����bean
			for(Iterator i= root.elementIterator("bean");i.hasNext();){
				 
				foo = (Element) i.next();
				
				//��ȡbean������id��class
				Attribute id = foo.attribute("id");
				Attribute cls = foo.attribute("class");
				
				//����Java������ƣ�ͨ��class�����ƻ�ȡClass����
				 Class bean = Class.forName(cls.getText());
				 //��ȡ��Ӧ��class��Ϣ
				 BeanInfo info = Introspector.getBeanInfo(bean);
				 //��ȡ��������
				 PropertyDescriptor[] pd = info.getPropertyDescriptors();
				 
				 //����ֵ�ķ���
				 Method mSet = null;
				 
				 //����һ������
				 Object obj = bean.newInstance();
				 
				 //������bean��property����
				  for(Iterator ite = foo.elementIterator("property"); ite.hasNext();){
					  Element foo2 = (Element) ite.next();
					  //��ȡproperty��name����
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
							  //��������,���ظ�����д������Method����
							  mSet = pdtor.getWriteMethod();
							  
							  //����Java�ķ��伫�µ��ö����ĳ��set����,����ֵ���ý�ȥ
							  //�൱�ڵ���set����
							  mSet.invoke(obj, value);
						  }
					  }
				  }
				  
				//���������beanMap�У�����keyΪidֵ��valueΪ����
				  beanMap.put(id.getText(), obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ͨ��bean��id��ȡbean�Ķ���
	 * @param beanName bean��id
	 * @return ���ض�Ӧ�Ķ���
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
