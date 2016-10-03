package org.yona.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*enum Vowel {
	VOWEL_A('a'), VOWEL_E('e'),VOWEL_I('i'),VOWEL_O('o'),VOWEL_U('u');
	private Character  sign ;
	Vowel(Character sign){
		this.sign = sign;
	}
	
	public String toString(){
		return this.sign +"";
	}
}*/
public class VowelGame {
	/**
	 * ������������Ϸ��������һ��Ӣ��������Ϸ��
	 * ���������ǽ�һ��Ӣ�ﵥ�ʵĵ�һ���������ص���ĸ�ƶ�����β���Ҽ��Ϻ�׺-ay
	 * ��Ʃ�硰banana�����ɡ�anana-bay����
	 */
	public static String getByGame(String str){
		String returnStr = "";
		String lastStr = "";
		boolean status = false;
		if(str != null && str != ""){
			for(int i = 0; i < str.length(); i++){
				Character c = str.charAt(i);
				if(status == false){
					if(c.equals('a') || c.equals('e') || c.equals('i') || c.equals('o') ||c.equals('u')
							|| c.equals('A') || c.equals('E') || c.equals('I') || c.equals('O') ||c.equals('U')){
						returnStr += c;
					}else{
						status = true;
						lastStr = "-" + c +"ay";
					}
				}else{
					returnStr += c;
				}
			}
			return returnStr + lastStr;
		}
		return "";
	}
	
	/**
	 * ͳ��Ԫ����ĸ��������һ���ַ�����ͳ�ƴ�����Ԫ����ĸ��������
	 * �����ӵ�Ļ�ͳ�Ƴ�ÿ��Ԫ����ĸ��������
	 * @param str
	 * @return
	 */
	public static int[] getEachVowelCount(String str){
		int[] count = {0,0,0,0,0};
		if(str != null && str != ""){
			for(int i = 0; i< str.length(); i++){
				Character c = str.charAt(i);
				switch (c) {
				case 'a':
				case 'A':
					count[0]++;
					break;
				case 'e':
				case 'E':
					count[1]++;
					break;
				case 'i':
				case 'I':
					count[2]++;
					break;
				case 'o':
				case 'O':
					count[3]++;
					break;
				case 'u':
				case 'U':
					count[4]++;
					break;
				default:
					break;
				}
			}
		}
		return count;
	}
	
	
}
