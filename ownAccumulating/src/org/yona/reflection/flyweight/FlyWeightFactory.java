package org.yona.reflection.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FlyWeightFactory {
	
		private Map<Integer,Object> map = new HashMap<Integer, Object>();
		public FlyWeightFactory(){
			
		}
		
		public FlyWeight factoryWay(int state){
			
			if(map.containsKey(state)){
				return (FlyWeight) map.get(state);
			}else{
				//����map�в��������״̬state,��state��ConcreteFlyWeight����
				//ȡ����ֵ��map
				map.put(state, new ConcreteFlyWeight(state));
				return (FlyWeight) map.get(state);
			}
		}
		
		/* 1ע�� ---����ֻ�Ǹ���ӡMap�ķ���,���Կ���Map�еĶ���Ĵ�������
		 * public void CheckMap(){
			//����ע��,ʹ�����͵�ʱ������Ų��ᱨ�����Ա���
			for(Map.Entry<Integer, Object> entry :map.entrySet()){
				System.out.println("Key = " + entry.getKey() +" :  Value = " + entry.getValue());
			}
			
		}*/
}
