package org.yona.reflection.abstractfactory;

public class FactoryTest {
	public static void main(String[] args) {
		AbstractServerFactory unixServerFactory = new UnixServerFactory();
		AbstractServerFactory windowsServerFactory = new WindowsServerFactory();
		//����unix ��������
		unixServerFactory.createBasicServer().showDetail();
		//����unix �߼�����
		unixServerFactory.createAdvanServer().showDetail();
		//����unix ���߼�����
		unixServerFactory.createPremServer().showDetail();
		
		//����windows ��������
		windowsServerFactory.createBasicServer().showDetail();
		//����windows �߼�����
		windowsServerFactory.createAdvanServer().showDetail();
		//����windows ���߼�����
		windowsServerFactory.createPremServer().showDetail();
		
	}
}
