package org.yona.design.flyweight.xmlexample;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.yona.design.flyweight.ConcreteFlyWeight;
import org.yona.design.flyweight.FlyWeight;

public class PosiInfoFactory {
		
		//��ְͬλ�Ĺ���Ԫ��Ϣ�޲�� ,�Ž�hashmap�б����ظ�
		private Map<Character,Object> map = new HashMap<Character, Object>();
		public PosiInfoFactory(){
			
		}
		
		public PosiInfo factoryWay(Character mark,String name, String detail){
			/*
			 * 	�����mark,���б�־�Ե��жϣ����Ϊa,b ��Ϊ������ϸ��
			 *  c~j ����ϸ��
			 */
			if(mark != null){
				mark = Character.toLowerCase(mark);
				switch (mark) {
				case 'a':
				case 'b':
						//ֱ�ӷ��ظö��󼴿�
						return new UnsharedConcretePosiInfo(mark, name, detail);
				case 'c':
				case 'd':
				case 'e':
				case 'f':
				case 'g':
				case 'h':
				case 'i':
				case 'j':
					if(map.containsKey(mark)){
						return  (PosiInfo) map.get(mark);
					}else{
						//����map�в��������״̬mark,��mark��ConcretePosiInfo����
						//ȡ����ֵ��map
						map.put(mark, new ConcretePosiInfo(mark, name, detail));
						return  (PosiInfo) map.get(mark);
					}
				default:
					break;
				}	
			}
			return null;
		}
		/* 1ע�� ---����ֻ�Ǹ���ӡMap�ķ���,���Կ���Map�еĶ���Ĵ�������
		 * public void CheckMap(){
			//����ע��,ʹ�����͵�ʱ������Ų��ᱨ�����Ա���
			for(Map.Entry<Integer, Object> entry :map.entrySet()){
				System.out.println("Key = " + entry.getKey() +" :  Value = " + entry.getValue());
			}
			
		}*/
}
