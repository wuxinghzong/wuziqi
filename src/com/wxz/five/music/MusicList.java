package com.wxz.five.music;

import java.applet.AudioClip;
import java.net.URL;

public class MusicList {
	//-------����                               
	private static AudioClip soundPut;
	private static AudioClip soundWin;
	private static AudioClip soundLost;
	static{
		//Class clazz=MusicList.class; 
		String[] choics = { "put.wav", "win.wav","lost.wav" }; //�����ļ�������
		 URL file1 =MusicList.class.getResource(choics[0]); //���������ļ�
	 	 URL file2 =MusicList.class.getResource(choics[1]); //��ʤ�����ļ�
	 	 URL file3 = MusicList.class.getResource(choics[2]); //ʧ�������ļ�
		soundPut = java.applet.Applet.newAudioClip(file1); //����������������
		soundWin = java.applet.Applet.newAudioClip(file2); //��ʤ������������
		soundLost = java.applet.Applet.newAudioClip(file3); //ʧ��������������
	}
	
	  
	  //��������
	  public static void putVoice(){
			soundPut.play();     
	  }
	  //��ʤ����
	  public static void winVoice(){
		   soundWin.play();
	  }
	  //ʧ������
	  public static void lostVoice(){
		  soundLost.play();
	  }
	  
}
