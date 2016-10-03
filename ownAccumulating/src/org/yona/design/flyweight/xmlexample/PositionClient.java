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
/*���һ����ְ��վ��������XML�ļ�����ʽ��ְλ�ϴ�����վ�ϡ� 
��վ�ڽ��յ�XML�ļ���ʱ�򣬾���Ҫ�������н����� 
XML�ļ� ���ݰ����� 
  a������ͷ�� 
  b���������Ҫ�� 
  C��ҽ�Ʊ��� 
  d����ҽ���� 
  e���ۿƱ��� 
  f��401 K 
  g�����ٹ���Сʱ�� 
  h����н�� 
  i���������� 
  j��������ַ 

��(c)��(j)��ϸ�ڶ�������ͬһ������������ְλ��˵������Ϊ����ͬ�ġ�

��ʹ����Ԫģʽ����ƽ��������XML�ļ��Լ����ɲ�ͬJob����Ĺ��̡� */

public class PositionClient {
	public static List<Position> xmlInit(String xml){
		List<Position> positions = null;
		try {
			//����xml
			//��ȡָ��λ�õ������ļ�
			SAXReader reader = new SAXReader();
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			//��classĿ¼�»�ȡָ����xml�ļ�
			InputStream ins = classLoader.getResourceAsStream(xml);
			Document doc = reader.read(ins);
			Element root = doc.getRootElement();
			Element job;
			//����һ��ְλ�����б����ڷ��ظ��ֲ�ͬ��ְλ����
			 positions = new ArrayList<Position>();
			 PosiInfoFactory pf = new PosiInfoFactory(); 
			for(Iterator i= root.elementIterator("job");i.hasNext();){
				//ְλ����
				Position position = new Position();
				//ְλ������Ϣ
				List<PosiInfo> posiList = new ArrayList<PosiInfo>();
				job = (Element) i.next();
				 //������job��pro����
				  for(Iterator ite = job.elementIterator("pro"); ite.hasNext();){
					  Element pro = (Element) ite.next();
					  //��ȡproperty��name����
					  Attribute name = pro.attribute("name");
					  Attribute id = pro.attribute("id");
					  String value = null;
					  for(Iterator ite1 = pro.elementIterator("value");ite1.hasNext();){
						  Element detail = (Element) ite1.next();
						  value = detail.getText();
						  break; 
					  }
					 //���ù��������ȡ��Ӧ��ְλ������Ϣ
					  //��factoryWay�����ж��ظ����ݹ�������
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
				System.out.println("==============ְλ��Ϣ��ʼ===============");
				for(PosiInfo  info : p.getPosiList()){
					System.out.println("��Ϣ���� "+ info);
					System.out.println("��Ϣ��ţ� "+info.getMark() +"  ��Ϣ���ƣ�" +
								info.getName()+"  ��Ϣ���ݣ�" + info.getDetail());
				}
				System.out.println("==============ְλ��Ϣ����===============");
				System.out.println();
			}
	}
}
