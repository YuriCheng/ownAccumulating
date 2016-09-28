package org.yona.reflection.abstractfactory;

public class WindowsServerFactory implements AbstractServerFactory{

	@Override
	public BasicServer createBasicServer() {
		return WindowsBasicServer.getInstance();
	}

	@Override
	public AdvanServer createAdvanServer() {
		return WindowsAdvanServer.getInstance();
	}

	@Override
	public PremServer createPremServer() {
		
		return WindowsPremServer.getInstance();
	}

}
