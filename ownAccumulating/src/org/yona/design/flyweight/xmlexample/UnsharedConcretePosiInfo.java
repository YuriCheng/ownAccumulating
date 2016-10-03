package org.yona.design.flyweight.xmlexample;

/**
 * 非共享的职位具体信息类
 *
 */
public class UnsharedConcretePosiInfo implements PosiInfo {

	//职位内容判断标志
	private Character mark;
	//职位内容信息
	private String detail;
	//职位内容名称
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
