package org.yona.text;

public class TextReverse {
	/**
	 * ��ת�ַ�����������һ���ַ�����������ת�������
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
