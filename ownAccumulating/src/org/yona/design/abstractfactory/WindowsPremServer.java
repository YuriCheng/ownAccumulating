package org.yona.design.abstractfactory;

public class WindowsPremServer extends PremServer{

	private static WindowsPremServer wps = null;
	private WindowsPremServer (){}
	
	@SuppressWarnings("unchecked")
	public static synchronized WindowsPremServer getInstance() {
	    if (wps == null) {
	        wps = new WindowsPremServer();
	    }
	    return wps;
	}

	@Override
	public void showDetail() {
		System.out.println("This is Windows Premiere Server!");
		
	}
}
