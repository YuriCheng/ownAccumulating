package org.yona.text;

public class TextReverse {
	/**
	 * 逆转字符串——输入一个字符串，将其逆转并输出。
	 */
	public static String getTextReverse(String str){
		String reverseStr = "";
		if(str != null && str != ""){
			for(int i = str.length(); i > 0; i--){
				reverseStr += str.charAt(i-1);
			}
		}
		return reverseStr;
	}
}
