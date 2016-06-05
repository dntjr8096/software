package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.User;
import model.database;

public class make extends JFrame {

	JPanel mainPanel;
	JPanel topPanel;
	JPanel westPanel;
	JButton resetBtn;
	JButton helpBtn;
	JTextArea idLabel;
	JButton bookAddBtn;
	JButton bookManageBtn;
	
	public make(database db, User user){
		mainPanel = new JPanel(new BorderLayout());
		topPanel = new JPanel(new GridLayout(1,4,5,5));
		westPanel = new JPanel(new BorderLayout());
		
		this.add(mainPanel);
		
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(westPanel, BorderLayout.WEST);
		
		resetBtn = new JButton("�ʱ�ȭ����");
		helpBtn = new JButton("����");
		
		topPanel.add(resetBtn);
		topPanel.add(helpBtn);
		
		idLabel = new JTextArea(user.getID() + "��\n�ȳ��ϼ���.");
		bookAddBtn = new JButton("å�߰�");
		bookManageBtn = new JButton("å����");
		
		JPanel btnPanel = new JPanel(new GridLayout(2,1,5,5));
		
		westPanel.add(idLabel,BorderLayout.NORTH);
		westPanel.add(btnPanel);
		
		btnPanel.add(bookAddBtn);
		btnPanel.add(bookManageBtn);		
	}
	
	public JButton getHelpBtn(){
		return helpBtn;
	}
	
	public JButton getresetBtn(){
		return resetBtn;
	}
	
	public JButton getbookAddBtn(){
		return bookAddBtn;
	}
	
	public JButton getbookManageBtn(){
		return bookManageBtn;
	}
	
	
	
	
	
}
