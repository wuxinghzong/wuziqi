package com.wxz.five.ui;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import com.wxz.five.bean.ChessTable;
import com.wxz.five.bean.ComputerPlayer;

public class MainUi {
	public static void main(String[] args) {
		JFrame  f=new JFrame("�������˻���ս(�㷨���by������)");
		JMenuBar menubar=new FiveMenuBar();
		//�������л�ȡ���� ����������
		JPanel pannel=new ChessPanel(ChessTable.getInstance().getList());
		f.setJMenuBar(menubar);
		f.add(pannel);
		f.setLocation(300, 40);
		f.setSize(620, 660);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���������߳�
		Thread th=new Thread(ComputerPlayer.getInstance());
		th.start();
		//���߳�ˢ�½���
		while(true){
			f.repaint();
		}
	
	}
}
