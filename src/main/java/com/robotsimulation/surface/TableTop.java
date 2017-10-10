package com.robotsimulation.surface;

public class TableTop {

	private int width;
	private int length;
	
	public TableTop(int width,int length){
		this.length=length;
		this.width=width;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
