package view;

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

import controller.helpEventHandler;
import controller.settingEventHandler;
import model.Book;
import model.User;
import model.XMLReader;
import model.database;

import java.io.*;

public class makeFirstFrame extends JFrame {

	private JPanel mainPanel;	// main panel
	private JPanel topPanel;	// top panel
	private JPanel menuPanel;	// menu Panel
	private JPanel bottomPanel;	// bottom Panel
	private JPanel recoBookPanel;	// 추천도서 패널
	private BookPanel bp;
	private JButton setting, help, bookManageBtn;
	private database db;
	
	public makeFirstFrame(database db, User user) {
		
		this.db = db;
		
		setLayout(new BorderLayout());
		
		mainPanel = new JPanel(new BorderLayout()); // main Panel
		this.add(mainPanel);
		
		topPanel = new JPanel(new BorderLayout()); // top Panel
		
		menuPanel = new JPanel(new GridLayout(1,2)); // menu Panel
		
		setting = new JButton("초기화설정");
		help = new JButton("도움말");
		
		menuPanel.add(setting);
		menuPanel.add(help);
		
		topPanel.add(menuPanel,BorderLayout.NORTH);
		
		JLabel helloWord = new JLabel("One man who has a mind and knows it can always beat ten men who haven't and don't.");
		
		topPanel.add(helloWord,BorderLayout.CENTER);
		mainPanel.add(topPanel,BorderLayout.NORTH);
		
		bottomPanel = new JPanel(new GridLayout(1,2));
		mainPanel.add(bottomPanel,BorderLayout.CENTER);
		
		recoBookPanel = new JPanel(new BorderLayout());
		
		recoBookPanel.add(new JLabel("추천도서"), BorderLayout.NORTH);
		
		bp = new BookPanel();
		
		bp.setLayout(new GridLayout(2,1));
		
		XMLReader xmlr = XMLReader.newInstance();
		ArrayList<Book> books = xmlr.getBestSeller();
		bp.setContent(books.get(0));	// 베스트셀러 보여줌

		recoBookPanel.add(bp);
		
		bottomPanel.add(recoBookPanel);
		
		bookManageBtn = new JButton("내책관리");
		
		bottomPanel.add(bookManageBtn);
		
		setting.addActionListener(new settingEventHandler(db));
		help.addActionListener(new helpEventHandler());
 }

	public JPanel getmainPanel(){
		return mainPanel;
	}
	 
	public JPanel gettopPanel(){
			return topPanel;
		}
	 
	public JPanel getmenuPanel(){
			return menuPanel;
		}
	 
	 public JPanel getbottomPanel(){
			return bottomPanel;
		}
	 
	 public JPanel getrecoBookPanel(){
			return recoBookPanel;
		}
	 
	 public JButton getsetting(){
		 return setting;
	 }
	 
	 public JButton gethelp(){
		 return help;
	 }
	 
	 public JButton getbookManageBtn(){
		 return bookManageBtn;
	 }
	  
}






