package com.wxz.five.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.wxz.five.action.MenuAction;
@SuppressWarnings("serial")
public class FiveMenuBar extends JMenuBar{
	
	private JMenu[] menu={new JMenu("��ʼ"),new JMenu("����"),new JMenu("����")};
	private JMenuItem[] menuitem1={new JMenuItem("���¿�ʼ"),new JMenuItem("����"),new JMenuItem("�˳�")};
	private JMenuItem[] menuitem2={new JMenuItem("�˻�����(�˺� ����)"),new JMenuItem("�˻�����(�˰� ����)"),new JMenuItem("���˶���")};
	private JMenuItem[] menuitem3={new JMenuItem("����"),new JMenuItem("����")};
	public FiveMenuBar() {
		init();
	}
	private void init(){
		//��ӵ��˵���
		for(int i=0;i<3;i++)
			menu[0].add(menuitem1[i]);
		for(int i=0;i<3;i++)
			menu[1].add(menuitem2[i]);
		for(int i=0;i<2;i++)
			menu[2].add(menuitem3[i]);
		for(int i=0;i<3;i++)
			this.add(menu[i]);
		addMenuAction();
	
	}
	
	private void addMenuAction(){
		menuitem1[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("���¿�ʼ");
				MenuAction.RestartAction();
				Container p = FiveMenuBar.this.getParent();
				p.repaint();
			}
		});
		menuitem1[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����");
				MenuAction.RollbackAction();
				Container p = FiveMenuBar.this.getParent();
				p.repaint();
			}
		});
		menuitem1[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�˳���");
				System.exit(1);
			}
		});

		menuitem2[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�˻�����0");
				MenuAction.RobotAction();
				Container p = FiveMenuBar.this.getParent();
				p.repaint();
			}
		});
		menuitem2[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�˻�����1");
				MenuAction.RobotAction1();
				Container p = FiveMenuBar.this.getParent();
				p.repaint();
			}
		});
		menuitem2[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("���˶���");
				MenuAction.HumenAction();
				Container p = FiveMenuBar.this.getParent();
				p.repaint();
			}
		});
		menuitem3[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����");
				MenuAction.RuleAction();
				Container p = FiveMenuBar.this.getParent();
				p.repaint();
			}
		});
		menuitem3[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����");
				MenuAction.AboutAction();
				Container p = FiveMenuBar.this.getParent();
				p.repaint();
			}
		});
		
	}
	
}
