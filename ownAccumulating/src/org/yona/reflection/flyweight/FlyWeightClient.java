package org.yona.reflection.flyweight;

public class FlyWeightClient {
		
	public static void main(String[] args) {
		
		//这个例子是工厂模式和FlyWeight(享元)模式的结合
		//通过 FlyWeight Design 在工厂中创建一个根据状态值，来创建对象(当对象不存在时)或者
		//来获取对象,由于是HashMap的关系,状态值是唯一的，所以每一次放在Map Value创建的对象
		//也是只有一次创建，也是唯一的。
		
		FlyWeightFactory factory = new FlyWeightFactory();
		
		/* 1注释
		 * factory.factoryWay(4);
		factory.factoryWay(2);
		factory.factoryWay(2);
		factory.factoryWay(1);
		factory.factoryWay(1);
		factory.factoryWay(3);
		factory.CheckMap();*/
		
		/* 2注释
		 * FlyWeight f1 = factory.factoryWay(4);
		FlyWeight f2 = factory.factoryWay(2);
		FlyWeight f3 = factory.factoryWay(2);
		FlyWeight f4 = factory.factoryWay(1);
		FlyWeight f5 = factory.factoryWay(1);
		FlyWeight f6 = factory.factoryWay(3);
		System.out.println(f1.getState() + " : " + f1);
		System.out.println(f2.getState() + " : " + f2);
		System.out.println(f3.getState() + " : " + f3);
		System.out.println(f4.getState() + " : " + f4);
		System.out.println(f5.getState() + " : " + f5);
		System.out.println(f6.getState() + " : " + f6);*/
		/**
		 * 2注释结果：
		 *  4 : org.yona.reflection.flyweight.ConcreteFlyWeight@65690726
			2 : org.yona.reflection.flyweight.ConcreteFlyWeight@525483cd
			2 : org.yona.reflection.flyweight.ConcreteFlyWeight@525483cd
			1 : org.yona.reflection.flyweight.ConcreteFlyWeight@2a9931f5
			1 : org.yona.reflection.flyweight.ConcreteFlyWeight@2a9931f5
			3 : org.yona.reflection.flyweight.ConcreteFlyWeight@2f9ee1ac
		 */
		
	}
	
}
