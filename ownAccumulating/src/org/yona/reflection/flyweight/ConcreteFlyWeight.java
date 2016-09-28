package org.yona.reflection.flyweight;

public class ConcreteFlyWeight implements FlyWeight {

	private int state;
	
	public ConcreteFlyWeight(){
		
	}
	
	public ConcreteFlyWeight(int state){
		this.state = state;
	}
	@Override
	public int getState() {
		
		return state;
	}

}
