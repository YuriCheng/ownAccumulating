package org.yona.reflection.flyweight;

public class FlyWeightClient {
		
	public static void main(String[] args) {
		
		//��������ǹ���ģʽ��FlyWeight(��Ԫ)ģʽ�Ľ��
		//ͨ�� FlyWeight Design �ڹ����д���һ������״ֵ̬������������(�����󲻴���ʱ)����
		//����ȡ����,������HashMap�Ĺ�ϵ,״ֵ̬��Ψһ�ģ�����ÿһ�η���Map Value�����Ķ���
		//Ҳ��ֻ��һ�δ�����Ҳ��Ψһ�ġ�
		
		FlyWeightFactory factory = new FlyWeightFactory();
		
		/* 1ע��
		 * factory.factoryWay(4);
		factory.factoryWay(2);
		factory.factoryWay(2);
		factory.factoryWay(1);
		factory.factoryWay(1);
		factory.factoryWay(3);
		factory.CheckMap();*/
		
		/* 2ע��
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
		 * 2ע�ͽ����
		 *  4 : org.yona.reflection.flyweight.ConcreteFlyWeight@65690726
			2 : org.yona.reflection.flyweight.ConcreteFlyWeight@525483cd
			2 : org.yona.reflection.flyweight.ConcreteFlyWeight@525483cd
			1 : org.yona.reflection.flyweight.ConcreteFlyWeight@2a9931f5
			1 : org.yona.reflection.flyweight.ConcreteFlyWeight@2a9931f5
			3 : org.yona.reflection.flyweight.ConcreteFlyWeight@2f9ee1ac
		 */
		
	}
	
}
