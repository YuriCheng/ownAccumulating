package org.yona.reflection;

public class GreetFactory {
	final String AMERICANGREET = "a";
	final String CHINESEGREET = "c";
		public GreetWays catchGreet(String type){
			
			if(type.equals(AMERICANGREET)){
				return new AmericanGreet();
			}else{
				return new ChineseGreet();
			}
		}
}
