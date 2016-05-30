
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

public class makeFirstFrame extends JFrame {

	
	public makeFirstFrame() {
		
		setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel(new BorderLayout()); // main Panel
		this.add(p1);
		
		JPanel p2 = new JPanel(new BorderLayout()); // top Panel
		
		JPanel p3 = new JPanel(new GridLayout(1,3)); // menu Panel
		
		JButton Btn1 = new JButton("버튼1");
		JButton Btn2 = new JButton("설정");
		JButton Btn3 = new JButton("도움말");
		
		p3.add(Btn1);
		p3.add(Btn2);
		p3.add(Btn3);
		

	    Btn1ListenerClass listener2 = new Btn1ListenerClass();		Btn1.addActionListener(listener2);
	    Btn2ListenerClass listener3 = new Btn2ListenerClass();		Btn2.addActionListener(listener3);
	    Btn3ListenerClass listener4 = new Btn3ListenerClass();		Btn3.addActionListener(listener4);

		
		p2.add(p3,BorderLayout.NORTH);
		
		JTextArea helloWord = new JTextArea("hello");
		
		p2.add(helloWord,BorderLayout.CENTER);
		
		p1.add(p2,BorderLayout.NORTH);
		
		JPanel p4 = new JPanel(new GridLayout(1,3)); // bottom Panel
		
		p1.add(p4,BorderLayout.CENTER);
		
		JPanel p5 = new JPanel(); // bottom 첫버째 패널 ( 임시로 만들어 놓음 )
		
		JPanel p6 = new JPanel(); // bottom 차트 패널 ( 임시로 만들어 놓음 )
		
		p4.add(p5);
		
		JButton bookManageBtn = new JButton("내책관리");
		
		p4.add(bookManageBtn);
		
		p4.add(p6);
		
		bookManageListenerClass listenerA = new bookManageListenerClass();		bookManageBtn.addActionListener(listenerA);

 }

	  class bookManageListenerClass implements ActionListener {

		  public void actionPerformed(ActionEvent e) {
			  JFrame frame2 = new JFrame();
			    frame2.setTitle("Course List");
			    frame2.setSize(800, 300);
			    frame2.setLocationRelativeTo(null);
			    frame2.setVisible(true);
		  }
		  
		  
		}
  
	  class Btn1ListenerClass implements ActionListener {
		  public void actionPerformed(ActionEvent e) {
			 
		  }
		}
	  
	  class Btn2ListenerClass implements ActionListener {
		  public void actionPerformed(ActionEvent e) {
			  Setting frameA = new Setting();
			    frameA.setTitle("Setting");
			    frameA.setSize(400, 600);
			    frameA.setLocationRelativeTo(null);
			    frameA.setVisible(true);
		  }
		}
	  
	  class Btn3ListenerClass implements ActionListener {
		  public void actionPerformed(ActionEvent e) {
			  Help frameB = new Help();
			    frameB.setTitle("Help");
			    frameB.setSize(400,600);
			    frameB.setLocationRelativeTo(null);
			    frameB.setVisible(true);
		  }
		}
	  
}






