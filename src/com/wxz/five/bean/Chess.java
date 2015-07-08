package com.wxz.five.bean;
/**
 * ������
 */

public class Chess {
	public final static int BLACK_CHESS=1;
	public final static int WHITE_CHESS=2;
	private int x;
	private int y;
	private int color; //1  BLACK_CHESS ��ɫ  2  WHITE_CHESS��ɫ
	
	public Chess(int x, int y, int color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public int getColor() {
		return color;
	}

	
}
