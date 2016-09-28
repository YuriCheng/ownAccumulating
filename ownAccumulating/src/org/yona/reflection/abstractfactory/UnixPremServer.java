package org.yona.reflection.abstractfactory;

public class UnixPremServer extends PremServer{

	private static UnixPremServer ups = null;
	private UnixPremServer (){}
	
	@SuppressWarnings("unchecked")
	public static synchronized UnixPremServer getInstance() {
	    if (ups == null) {
	        ups = new UnixPremServer();
	    }
	    return ups;
	}

	@Override
	public void showDetail() {
		System.out.println("This is Unix Premiere Server!");
		
	}
}
