package org.yona.reflection.abstractfactory;

public class WindowsBasicServer extends BasicServer{

	private static WindowsBasicServer wbs = null;
	private WindowsBasicServer (){}
	
	@SuppressWarnings("unchecked")
	public static synchronized WindowsBasicServer getInstance() {
	    if (wbs == null) {
	        wbs = new WindowsBasicServer();
	    }
	    return wbs;
	}

	@Override
	public void showDetail() {
		System.out.println("This is Windows Basic Server!");
		
	}
}
