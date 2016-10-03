package org.yona.design.flyweight.xmlexample;

/**
 * �ǹ����ְλ������Ϣ��
 *
 */
public class UnsharedConcretePosiInfo implements PosiInfo {

	//ְλ�����жϱ�־
	private Character mark;
	//ְλ������Ϣ
	private String detail;
	//ְλ��������
	private String name;
	
	public UnsharedConcretePosiInfo(){
		
	}
	public UnsharedConcretePosiInfo(Character mark, String name, String detail){
		this.mark = mark;
		this.detail = detail;
		this.name  = name;
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
