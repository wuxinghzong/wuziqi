package com.wxz.five.bean;

public class PersonPlayer {
	private int PlayChessColor=0; //0:�������̶�  1������� 2���°���
	private ChessTable table;
	private static PersonPlayer p=new PersonPlayer();
	private PersonPlayer() {
		table=ChessTable.getInstance();
	}
	public static PersonPlayer getInstance(){
		return p;
	}
	
	public int getPlayChessColor() {
		return PlayChessColor;
	}
	
	public void setPlayChessColor(int playChessColor) {
		PlayChessColor = playChessColor;
	}
	
	public boolean chessPlay(Chess chess) {
		//��ȡ������Ӧ���������ɫ
		int tc=Chess.WHITE_CHESS;
		if(table.getPlayColorFlag()){
			tc=Chess.BLACK_CHESS;
		}
		if(PlayChessColor==0&&chess.getColor()==tc){
			boolean b=table.playChessInTable(chess);
			return b;
		}
		if(PlayChessColor==chess.getColor()&&chess.getColor()==tc){
			boolean b=table.playChessInTable(chess);
			return b;
		}
		return false;
	}

}
