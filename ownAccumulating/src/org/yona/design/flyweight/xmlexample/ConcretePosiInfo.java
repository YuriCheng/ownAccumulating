package org.yona.design.flyweight.xmlexample;

/**
 * �����ְλ������Ϣ��
 *
 */
public class ConcretePosiInfo implements PosiInfo {

	//ְλ�����жϱ�־
	private Character mark;
	//ְλ������Ϣ
	private String detail;
	//ְλ��������
	private String name;
	
	public ConcretePosiInfo(){
		
	}
	public ConcretePosiInfo(Character mark, String name,String detail){
		this.mark = mark;
		this.detail = detail;
		this.name = name;
	}
	@Override
	public Character getMark() {
		return mark;
	}
	@Override
	public String getDetail() {
		return detail;
	}
	@Override
	public String getName() {
		return name;
	}

}
