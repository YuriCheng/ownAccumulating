package org.yona.text;

/**
 * �ж��Ƿ�Ϊ���ġ����ж��û�������ַ����Ƿ�Ϊ���ġ�
 * ������ָ����ƴд��ʽ����һ���Ĵʣ�Ʃ�硰racecar����
 *
 */
public class TextPalindrome {
	public static boolean isPalindrome(String str){
		boolean status = false;
		if(str != null && str !=""){
			if(str.length() >= 2){
				int length = str.length()/2;
				String reverseOrder = "";
				String positiveOrder = "";
				for(int i = 0; i<length; i++){
					positiveOrder += str.charAt(i);
				}
				for(int j = str.length()-1; j >str.length() - length-1;j--){
					reverseOrder += str.charAt(j);
				}
				System.out.println(positiveOrder);
				System.out.println(reverseOrder);
				if(positiveOrder.equals(reverseOrder)){
					status = true;
				}
			}
		}
		return status;
	}
}
