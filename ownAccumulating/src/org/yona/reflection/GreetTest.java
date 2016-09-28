package org.yona.reflection;

public class GreetTest {
	public static void main(String[] args) {
		/*GreetWays cGreetWays = new ChineseGreet();
		GreetWays aGreetWays = new AmericanGreet();
		
		cGreetWays.greetingWay("Yona");
		aGreetWays.greetingWay("Yona");*/
		
		//使用工厂模式来实现
		GreetFactory gf = new GreetFactory();
		GreetWays aCatchGreet = gf.catchGreet("a");
		aCatchGreet.greetingWay("Yona");
		GreetWays cCatchGreet = gf.catchGreet("c");
		cCatchGreet.greetingWay("Yona");
	}
}
