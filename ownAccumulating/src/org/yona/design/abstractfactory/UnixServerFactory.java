package org.yona.design.abstractfactory;

public class UnixServerFactory implements AbstractServerFactory{

	@Override
	public BasicServer createBasicServer() {
		return UnixBasicServer.getInstance();
	}

	@Override
	public AdvanServer createAdvanServer() {
		return UnixAdvanServer.getInstance();
	}

	@Override
	public PremServer createPremServer() {
		
		return UnixPremServer.getInstance();
	}

}
