package org.yona.design.abstractfactory;

public class WindowsAdvanServer extends AdvanServer{

	private static WindowsAdvanServer was = null;
	private WindowsAdvanServer (){}
	
	@SuppressWarnings("unchecked")
	public static synchronized WindowsAdvanServer getInstance() {
	    if (was == null) {
	        was = new WindowsAdvanServer();
	    }
	    return was;
	}

	@Override
	public void showDetail() {
		System.out.println("This is Windows Advance Server!");
	}
}
