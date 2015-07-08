package com.wxz.five.action;

import javax.swing.JOptionPane;

import com.wxz.five.bean.Chess;
import com.wxz.five.bean.ChessTable;
import com.wxz.five.bean.ComputerPlayer;
import com.wxz.five.bean.PersonPlayer;

public class MenuAction {
	private static ChessTable table;
	static{
		table=ChessTable.getInstance();
	}
	public static void RestartAction(){
		//���¿�ʼ
		table.resetTable();
	}
	public static void RollbackAction(){
		//����
		table.robackTable();
		if(table.getPlayWayFlag()!=table.H_H){
			table.robackTable();
		}
	}
	public static void RobotAction(){
		//�˻�����
		table.setPlayWayFlag(0);
		//���¿�ʼ
		table.resetTable();
		//����
		ComputerPlayer com = ComputerPlayer.getInstance();
		com.setPlayChessColor(Chess.WHITE_CHESS);
		PersonPlayer.getInstance().setPlayChessColor(Chess.BLACK_CHESS);
		
	}
	public static void RobotAction1() {
		//�˻�����
		table.setPlayWayFlag(1);
		//���¿�ʼ
		table.resetTable();
		//����
		ComputerPlayer com = ComputerPlayer.getInstance();
		com.setPlayChessColor(Chess.BLACK_CHESS);
		PersonPlayer.getInstance().setPlayChessColor(Chess.WHITE_CHESS);
	}                                                                                                                                                                                                                           
	public static void HumenAction(){
		//���˶���
		table.setPlayWayFlag(2);
		//���¿�ʼ
		table.resetTable();
		PersonPlayer.getInstance().setPlayChessColor(0);
	}
	
	public static void RuleAction(){
		//��  ��
		JOptionPane.showConfirmDialog(null,
      			"1���޽��֣�" +"\n"+
				"   �ڰ�˫���������ӣ���һ�������������γ����������(���������)���ӵ�һ��Ϊʤ��" +"\n"+
				"2���н��֣����߽��־��䣬���ֲ������ӣ�" +"\n"+
				"   �����޽��ֹ�������ʤ�����ǲ��ϲ���һЩ�������ƺ������е����ƣ���ƽ��ڰ�˫������ʽ��" +"\n"+
				"   ������Ժ���ĸ��ֽ������γɡ�" +"\n"+
				"   ������Ҫ��Ϊ���¼��ࣺ" +"\n"+
				"   (1)�ڳ������֣�������������������ͬ�����ӡ�" +"\n"+
				"   (2)���������֣��������ϵĻ�����" + "\n"+
				"   (3)�����Ľ��֣��������ϵ��ġ�" + "\n"+
				"   ��������Ժ�����Եģ�����û���κν��֡�" ,"����",
				JOptionPane.CLOSED_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
	}
	public static void AboutAction(){
		//��  ��
		JOptionPane.showConfirmDialog(null, 
				"��   �ߣ�\n" +
				"     ������  \n" +
				"��ϵ�绰��\n" +
				"     13599840407\n", 
				"��  ��", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}
	
}
