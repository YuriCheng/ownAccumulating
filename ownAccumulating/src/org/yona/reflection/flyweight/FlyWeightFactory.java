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
				//假如map中不包含这个状态state,则将state的ConcreteFlyWeight对象
				//取出赋值给map
				map.put(state, new ConcreteFlyWeight(state));
				return (FlyWeight) map.get(state);
			}
		}
		
		/* 1注释 ---这里只是个打印Map的方法,可以看出Map中的对象的创建个数
		 * public void CheckMap(){
			//这里注意,使用类型的时候这里才不会报错，可以遍历
			for(Map.Entry<Integer, Object> entry :map.entrySet()){
				System.out.println("Key = " + entry.getKey() +" :  Value = " + entry.getValue());
			}
			
		}*/
}
