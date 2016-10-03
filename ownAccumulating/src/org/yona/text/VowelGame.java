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
	 * 拉丁猪文字游戏——这是一个英语语言游戏。
	 * 基本规则是将一个英语单词的第一个辅音音素的字母移动到词尾并且加上后缀-ay
	 * （譬如“banana”会变成“anana-bay”）
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
	 * 统计元音字母——输入一个字符串，统计处其中元音字母的数量。
	 * 更复杂点的话统计出每个元音字母的数量。
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
