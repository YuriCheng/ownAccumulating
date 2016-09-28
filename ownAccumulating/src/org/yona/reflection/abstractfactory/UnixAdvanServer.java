package org.yona.reflection.abstractfactory;

public class UnixAdvanServer extends AdvanServer{

	private static UnixAdvanServer uas = null;
	private UnixAdvanServer (){}
	
	@SuppressWarnings("unchecked")
	public static synchronized UnixAdvanServer getInstance() {
	    if (uas == null) {
	        uas = new UnixAdvanServer();
	    }
	    return uas;
	}

	@Override
	public void showDetail() {
		System.out.println("This is Unix Advance Server!");
		
	}
}
