package com.wxz.five.util;

import javax.swing.JOptionPane;

import com.wxz.five.bean.Chess;
import com.wxz.five.bean.ChessTable;
import com.wxz.five.music.MusicList;

public class WinUtil {

	public static void WinShow(ChessTable table,Chess chess){
		if(table.isVictory(chess)){
			MusicList.winVoice();
			if(chess.getColor()==Chess.BLACK_CHESS){
				JOptionPane.showConfirmDialog(null, 
					"����Ӯ�ˣ��������׷�����Ŭ���� ", "��     ��", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			
			}else{
				JOptionPane.showConfirmDialog(null, 
				 "����Ӯ�ˣ��������ڷ�����Ŭ���� ", "��     ��", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
}
