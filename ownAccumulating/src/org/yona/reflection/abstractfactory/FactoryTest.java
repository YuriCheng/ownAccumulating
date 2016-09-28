package org.yona.reflection.abstractfactory;

public class FactoryTest {
	public static void main(String[] args) {
		AbstractServerFactory unixServerFactory = new UnixServerFactory();
		AbstractServerFactory windowsServerFactory = new WindowsServerFactory();
		//调用unix 基础服务
		unixServerFactory.createBasicServer().showDetail();
		//调用unix 高级服务
		unixServerFactory.createAdvanServer().showDetail();
		//调用unix 更高级服务
		unixServerFactory.createPremServer().showDetail();
		
		//调用windows 基础服务
		windowsServerFactory.createBasicServer().showDetail();
		//调用windows 高级服务
		windowsServerFactory.createAdvanServer().showDetail();
		//调用windows 更高级服务
		windowsServerFactory.createPremServer().showDetail();
		
	}
}
