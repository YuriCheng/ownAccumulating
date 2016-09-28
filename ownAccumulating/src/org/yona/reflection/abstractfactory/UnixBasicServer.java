package org.yona.reflection.abstractfactory;

public class UnixBasicServer extends BasicServer{

	private static UnixBasicServer ubs = null;
	private UnixBasicServer (){}
	
	@SuppressWarnings("unchecked")
	public static synchronized UnixBasicServer getInstance() {
	    if (ubs == null) {
	        ubs = new UnixBasicServer();
	    }
	    return ubs;
	}

	@Override
	public void showDetail() {
		System.out.println("This is Unix Basic Server!");
		
	}
}
