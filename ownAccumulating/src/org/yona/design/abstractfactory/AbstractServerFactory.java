package org.yona.design.abstractfactory;

/*请运用抽象工厂模式、存取器模式、私有方法、单例模式实现以下设计需求：
假设有一个Web托管公司，该公司在Windows和UNIX平台上托管服务。
该Web托管公司在这两种平台上提供三种不同类型的托管服务：基本（basic）、高级（advanced）和更高级（premiere）。
请设计一个应用，提供查询该Web托管公司提供的不同类型的托管包的功能。*/

public  interface AbstractServerFactory {
	//提供三种服务
	public BasicServer createBasicServer();
	public AdvanServer createAdvanServer();
	public PremServer createPremServer();
}
