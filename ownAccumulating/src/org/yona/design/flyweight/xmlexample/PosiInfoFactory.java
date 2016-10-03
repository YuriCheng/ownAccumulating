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
		
		//不同职位的共享元信息无差别 ,放进hashmap中避免重复
		private Map<Character,Object> map = new HashMap<Character, Object>();
		public PosiInfoFactory(){
			
		}
		
		public PosiInfo factoryWay(Character mark,String name, String detail){
			/*
			 * 	这里对mark,进行标志性的判断，如果为a,b 则为不共享细节
			 *  c~j 共享细节
			 */
			if(mark != null){
				mark = Character.toLowerCase(mark);
				switch (mark) {
				case 'a':
				case 'b':
						//直接返回该对象即可
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
						//假如map中不包含这个状态mark,则将mark的ConcretePosiInfo对象
						//取出赋值给map
						map.put(mark, new ConcretePosiInfo(mark, name, detail));
						return  (PosiInfo) map.get(mark);
					}
				default:
					break;
				}	
			}
			return null;
		}
		/* 1注释 ---这里只是个打印Map的方法,可以看出Map中的对象的创建个数
		 * public void CheckMap(){
			//这里注意,使用类型的时候这里才不会报错，可以遍历
			for(Map.Entry<Integer, Object> entry :map.entrySet()){
				System.out.println("Key = " + entry.getKey() +" :  Value = " + entry.getValue());
			}
			
		}*/
}
