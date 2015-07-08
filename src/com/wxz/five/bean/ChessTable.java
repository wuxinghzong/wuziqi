package com.wxz.five.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessTable {
	private final static int TABLE_SIZE=19; 
	private int[][] table=new int[TABLE_SIZE][TABLE_SIZE]; //0:��   1����  2����
	public final static int H_H=2;    //���˶���
	public final static int Hb_Rw=0;  //�˻����� �˺ڻ���
	public final static int Hw_Rb=1;  //�˻�����  �˰׻���
	private int  playWayFlag=0;        //���巽ʽ(�˻���������) 
	private int[][][] blacktable=new int [TABLE_SIZE][TABLE_SIZE][4];  //0����  1����
	private int[][][] whitetable=new int [TABLE_SIZE][TABLE_SIZE][4];   //[4] Ϊ�ĸ�����   0:����   1��   2����   3�� 
	private List<Chess> list;
	private boolean playColorFlag=true; //������ɫtrue:��ɫ     false:��ɫ 
	private boolean gameOver=false;    //�Ƿ������Ϸ
	private int maxChessX=12; 		//�������ӵ����x��yֵ
	private int maxChessY=12;
	private int minChessX=6;
	private int minChessY=6;
	private static ChessTable chtable=new ChessTable();
	private ChessTable() {
		list=new ArrayList<Chess>();
	}
	

	public int getMaxChessX() {
		return maxChessX;
	}

	public int getMaxChessY() {
		return maxChessY;
	}

	public int getMinChessX() {
		return minChessX;
	}


	public int getMinChessY() {
		return minChessY;
	}

	public int getPlayWayFlag() {
		return playWayFlag;
	}

	public void setPlayWayFlag(int playWayFlag) {
		this.playWayFlag = playWayFlag;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public void ChangcePlayColorFlag() {
		this.playColorFlag=playColorFlag^true;
	}

	public void setPlayColorFlag(boolean playColorFlag) {
		this.playColorFlag = playColorFlag;
	}

	public boolean getPlayColorFlag() {
		return playColorFlag;
	}

	public int[][] getTable() {
		return table;
	}

	public List<Chess> getList() {
		return list;
	}

	public int[][][] getBlacktable() {
		return blacktable;
	}


	public int[][][] getWhitetable() {
		return whitetable;
	}

	//������� ��ȡ������Ϣ
	public static ChessTable getInstance(){
		return chtable;
	}
	
	//������������
	public boolean playChessInTable(Chess chess){
		int x=chess.getX();
		int y=chess.getY();
		int color=chess.getColor();
		//�õط�û������ ������
		if(table[x][y]==0){
			//���Ӽӵ����ӵ��б���;
			//���java.util.ConcurrentModificationException�쳣
 			synchronized (list) {
 				list.add(chess);
			}
			//�޸�������Ϣ
			table[x][y]=color;
			//�޸�������ɫ��ı�־
			ChangcePlayColorFlag();
			//�������XYֵ
			updateXY(chess);
			//���µ÷ֱ�
			updateScore();
			return true;
		}
		return false;
	}
	//��������x��yֵ
	private void updateXY(Chess chess){
		if(maxChessX<=chess.getX()){
			if(chess.getX()+2<=18){
				maxChessX=chess.getX()+1;
			}else if(chess.getX()+1<=18){
					maxChessX=chess.getX()+1;
					}else{
						maxChessX=chess.getX();
					}
		}
		if(maxChessY<=chess.getY()){
			if(chess.getY()+2<=18){
				maxChessY=chess.getY()+2;
			}else if(chess.getY()+1<=18){
					maxChessY=chess.getY()+1;
					}else{
						maxChessY=chess.getY();
						}
		}
		if(minChessX>=chess.getX()){
			if(chess.getX()-2>=0){
				minChessX=chess.getX()-2;
			}else if(chess.getX()-1>=0){
					minChessX=chess.getX()-1;
				}else{
					minChessX=chess.getX();
				}
		}
		if(minChessY>=chess.getY()){
			if(chess.getY()-2>=0){
				minChessY=chess.getY()-2;
			}else if(chess.getY()-1>=0){
					minChessY=chess.getY()-1;
				}else{
					minChessY=chess.getY();
				}
		}
	}
	//�������x+1��y+1��Χ�ڵ�����û�����ӵı߽�ֵ
	private void updateScore(){
		int[] countb=new int[4];
		int[] countw=new int[4];
		for(int i=minChessX ;i<=maxChessX;i++){
			for(int j=minChessY;j<=maxChessY;j++){
				if(table[i][j]==0){
					countb=CalcMaxValue(new Chess(i,j,Chess.BLACK_CHESS));
					countw=CalcMaxValue(new Chess(i,j,Chess.WHITE_CHESS));
					for(int k=0;k<4;k++){
						blacktable[i][j][k]=countb[k];
						whitetable[i][j][k]=countw[k];
					}
				}
			}
		}
	}
	//��������
	public void resetTable(){
		list.clear();
		for(int i=0;i<19;i++){
			for(int j=0;j<19;j++){
				table[i][j]=0;
				for(int k=0;k<4;k++){
					blacktable[i][j][k]=0;
					whitetable[i][j][k]=0;
				}
			}
		}
		setPlayColorFlag(true);
		setGameOver(false);
	}
	//���� ������һ��
	public void robackTable(){
		if(list.size()!=0){
			Chess chess=list.remove(list.size()-1);
			//���Գ���
			if(chess!=null)
			{	
				int x=chess.getX();
				int y=chess.getY();
				int color=chess.getColor();
				//�޸�������Ϣ
				table[x][y]=0;
				ChangcePlayColorFlag();
				setGameOver(false);
			}
		}
	}
	//�ж�ʤ�� ������һ�����ӣ��ж�һ��ʤ��
	public boolean isVictory(Chess chess){
		int[] count=CalcMaxValue(chess);
		//�������ֵ
		Arrays.sort(count);
		int max=count[3];
		if(max>=5){
			setGameOver(true);
			return true;
		}
		return false;
	}
	//����һ�����Ӻ��ø����ӵ��ĸ����������ֵ
	private int[] CalcMaxValue(Chess chess){
		int x=chess.getX();
		int y=chess.getY();
		int color=chess.getColor();
		int[] count={1,1,1,1};
		//����
		int tx=x-1;
		int ty=y-1;
		while(tx>=0&&ty>=0&&table[tx][ty]==color){
			count[0]++;
			tx--;
			ty--;
		}
		//����
		tx=x+1;
		ty=y+1;
		while(tx<=18&&ty<=18&&table[tx][ty]==color){
			count[0]++;
			tx++;
			ty++;
		}
		//��
		tx=x;
		ty=y-1;
		while(ty>=0&&table[tx][ty]==color){
			count[1]++;
			ty--;
		}
		//��
		tx=x;
		ty=y+1;
		while(ty<=18&&table[tx][ty]==color){
			count[1]++;
			ty++;
		}	
		//����
		tx=x+1;
		ty=y-1;
		while(tx<=18&&ty>=0&&table[tx][ty]==color){
			count[2]++;
			tx++;
			ty--;
		}
		//����
		tx=x-1;
		ty=y+1;
		while(tx>=0&&ty<=18&&table[tx][ty]==color){
			count[2]++;
			tx--;
			ty++;
		}
		//��
		tx=x+1;
		ty=y;
		while(tx<=18&&table[tx][ty]==color){
			count[3]++;
			tx++;
		}
		//��
		tx=x-1;
		ty=y;
		while(tx>=0&&table[tx][ty]==color){
			count[3]++;
			tx--;
		}
		return count;
	}
}
