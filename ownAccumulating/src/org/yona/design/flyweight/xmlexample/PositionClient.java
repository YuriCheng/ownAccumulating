package org.yona.design.flyweight.xmlexample;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/*设计一个求职网站，雇主以XML文件的形式将职位上传到网站上。 
网站在接收到XML文件的时候，就需要对它进行解析。 
XML文件 内容包括： 
  a．工作头衔 
  b．最低能力要求 
  C．医疗保险 
  d．牙医保险 
  e。眼科保护 
  f．401 K 
  g．最少工作小时数 
  h．带薪假 
  i．雇主姓名 
  j．雇主地址 

从(c)到(j)的细节对于来自同一个雇主的所有职位来说都被认为是相同的。

请使用享元模式来设计解析输入的XML文件以及生成不同Job对象的过程。 */

public class PositionClient {
	public static List<Position> xmlInit(String xml){
		List<Position> positions = null;
		try {
			//解析xml
			//读取指定位置的配置文件
			SAXReader reader = new SAXReader();
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			//从class目录下获取指定的xml文件
			InputStream ins = classLoader.getResourceAsStream(xml);
			Document doc = reader.read(ins);
			Element root = doc.getRootElement();
			Element job;
			//创建一个职位对象列表用于返回各种不同的职位对象
			 positions = new ArrayList<Position>();
			 PosiInfoFactory pf = new PosiInfoFactory(); 
			for(Iterator i= root.elementIterator("job");i.hasNext();){
				//职位对象
				Position position = new Position();
				//职位对象信息
				List<PosiInfo> posiList = new ArrayList<PosiInfo>();
				job = (Element) i.next();
				 //遍历该job的pro属性
				  for(Iterator ite = job.elementIterator("pro"); ite.hasNext();){
					  Element pro = (Element) ite.next();
					  //获取property的name属性
					  Attribute name = pro.attribute("name");
					  Attribute id = pro.attribute("id");
					  String value = null;
					  for(Iterator ite1 = pro.elementIterator("value");ite1.hasNext();){
						  Element detail = (Element) ite1.next();
						  value = detail.getText();
						  break; 
					  }
					 //利用工厂对象获取相应的职位具体信息
					  //在factoryWay方法中对重复内容共享属性
					 posiList.add(pf.factoryWay(id.getText().charAt(0), name.getText() , value));
				  }
				  position.setPosiList(posiList);
				  positions.add(position);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return positions;
	}
	public static void main(String[] args) {
		List<Position> postions = PositionClient.xmlInit("position.xml");
			for(Position p : postions){
				System.out.println("==============职位信息开始===============");
				for(PosiInfo  info : p.getPosiList()){
					System.out.println("信息对象： "+ info);
					System.out.println("信息编号： "+info.getMark() +"  信息名称：" +
								info.getName()+"  信息内容：" + info.getDetail());
				}
				System.out.println("==============职位信息结束===============");
				System.out.println();
			}
	}
}
