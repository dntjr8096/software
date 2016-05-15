
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.io.*;

public class makeBookList extends JFrame {

	private info datas = new info();
	  
	private JTable userTable = new JTable();
	private JScrollPane listJs = new JScrollPane(userTable);
	private JPanel listPanel = new JPanel(new BorderLayout());
	 
	private makeTable myCourseTable = new makeTable(userTable, listJs, listPanel);
	 
	public makeBookList() {
		
    JPanel p1 = new JPanel(new GridLayout(2, 3));

    p1.add(new JLabel("å ����"));	p1.add(new JLabel("����"));	p1.add(new JLabel("�б� ������ ��¥"));	p1.add(new JLabel("���� ������"));
    p1.add(datas.getbookName());	p1.add(datas.getwriter());		p1.add(datas.getstartTime());	p1.add(datas.geting());
   
    JPanel p2 = new JPanel(new BorderLayout());
    
    p2.add(new JTextField("���� �Է��� �ϰų� ����Ʈ���� �����Ͽ� å������ ������ �ּ���"), BorderLayout.SOUTH);
    p2.add(p1, BorderLayout.CENTER);
   
    JPanel topTab = new JPanel(new GridLayout(1,4));
    
    JButton jbtInsert = new JButton("�Է�");	JButton jbtAvg = new JButton("���");	JButton jbtSet = new JButton("����");	JButton jbtHelp = new JButton("����");
    topTab.add(jbtInsert);							topTab.add(jbtAvg);						topTab.add(jbtSet);						topTab.add(jbtHelp);
    
    InsertListenerClass listenerA = new InsertListenerClass();		jbtInsert.addActionListener(listenerA);
    AvgListenerClass listenerB = new AvgListenerClass();		jbtAvg.addActionListener(listenerB);
    SetListenerClass listenerC = new SetListenerClass();		jbtSet.addActionListener(listenerC);
    HelpListenerClass listenerD = new HelpListenerClass();		jbtHelp.addActionListener(listenerD);
    
    p2.add(topTab, BorderLayout.NORTH);
    
    JPanel p3 = new JPanel(new BorderLayout());          
    
    p3.add(p2, BorderLayout.NORTH);
    add(p3, BorderLayout.CENTER);
    
    
    JPanel p4 = new JPanel(new GridLayout(4, 1));

    JButton jbtAdd = new JButton("å �߰�");	JButton jbtList = new JButton("å ����Ʈ");	JButton jbtLoad = new JButton("�ҷ�����");	JButton jbtSave = new JButton("����");
    p4.add(jbtAdd);							p4.add(jbtList);						p4.add(jbtLoad);						p4.add(jbtSave);
    
    AddListenerClass listener1 = new AddListenerClass();		jbtAdd.addActionListener(listener1);
    ListListenerClass listener2 = new ListListenerClass();		jbtList.addActionListener(listener2);
    LoadListenerClass listener3 = new LoadListenerClass();		jbtLoad.addActionListener(listener3);
    SaveListenerClass listener4 = new SaveListenerClass();		jbtSave.addActionListener(listener4);

    add(p4, BorderLayout.WEST);

    JPanel centerPanel = new JPanel(new GridLayout(2,1));
    JTextArea chartPanel = new JTextArea("��Ʈ�� �� �κ�");
    
	centerPanel.add(listPanel);
	centerPanel.add(chartPanel);
	
	p3.add(centerPanel, BorderLayout.CENTER);
 }

  /** Main method */
  public static void main(String[] args) {
	
	makeBookList frame = new makeBookList();
    frame.setTitle("MakeCourseSchedule");
    frame.setSize(1000, 600);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.setVisible(true);
	
  }
  
  class InsertListenerClass implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	
	  }
	}
  
  class AvgListenerClass implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	
	  }
	}
  
  class SetListenerClass implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		  Setting frameA = new Setting();
		    frameA.setTitle("Setting");
		    frameA.setSize(400, 600);
		    frameA.setLocationRelativeTo(null);
		    frameA.setVisible(true);
	  }
	}
  
  class HelpListenerClass implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		  Help frameB = new Help();
		    frameB.setTitle("Help");
		    frameB.setSize(400,600);
		    frameB.setLocationRelativeTo(null);
		    frameB.setVisible(true);
	  }
	}
  
  class AddListenerClass implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		  myCourseTable.addRow(datas.getbookNameString(),datas.getwriterString(),datas.getstartTimeString(),datas.getingString());
	  }
  }

  class ListListenerClass implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		  bookList frame2 = new bookList(datas);
		    frame2.setTitle("Course List");
		    frame2.setSize(800, 300);
		    frame2.setLocationRelativeTo(null);
		    frame2.setVisible(true);
	  }
	}

  class LoadListenerClass implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		  fileControl load = new fileControl("MybookList.txt",myCourseTable);
		  load.read();
	  }
	}
  

  class SaveListenerClass implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		fileControl save = new fileControl("MybookList.txt",myCourseTable);
		save.renewFile();
	  }
	}
  
}






