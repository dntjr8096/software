package view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class MyBookFrame extends JFrame{
	private JButton add, delete;
	private JScrollPane jsp;
	private ArrayList<BookPanel> bookpanels;
	
	public MyBookFrame(){
		add = new JButton("å �߰�");
		delete = new JButton("å ����");
		
	}
	
}
