package org.yona.design.flyweight.xmlexample;

import java.util.ArrayList;
import java.util.List;

public class Position {
	//职位信息 PosiInfo的列表
	private    List<PosiInfo> posiList =  new ArrayList<PosiInfo>();

	public List<PosiInfo> getPosiList() {
		return posiList;
	}

	public void setPosiList(List<PosiInfo> posiList) {
		this.posiList = posiList;
	}
}
