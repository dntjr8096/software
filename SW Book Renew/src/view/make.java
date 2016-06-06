package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.print.Book;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import model.User;
import model.XMLReader;
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
	XMLReader reader; 
	database db;
	User user;
	Border bestBorder = BorderFactory.createTitledBorder("베스트 셀러");
	Border specialBorder = BorderFactory.createTitledBorder("주목할만한 신간도서");
	
	public make(database db, User user, XMLReader reader){
		this.db = db;
		this.user = user;
		this.reader = reader;
		
		mainPanel = new JPanel(new BorderLayout(5,5));
		topPanel = new JPanel(new GridLayout(1,4,5,5));
		westPanel = new JPanel(new BorderLayout());
		
		this.add(mainPanel);
		
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(westPanel, BorderLayout.WEST);
		
		resetBtn = new JButton("초기화설정");
		helpBtn = new JButton("도움말");
		
		topPanel.add(resetBtn);
		topPanel.add(helpBtn);
		
		idLabel = new JTextArea(user.getID() + "님\n안녕하세요.");
		bookAddBtn = new JButton("책추가");
		bookManageBtn = new JButton("책관리");
		
		JPanel btnPanel = new JPanel(new GridLayout(2,1,5,5));
		
		westPanel.add(idLabel,BorderLayout.NORTH);
		westPanel.add(btnPanel);
		
		btnPanel.add(bookAddBtn);
		btnPanel.add(bookManageBtn);	
		
		JPanel centerPanel = new JPanel(new GridLayout(2,1));
		BookPanel bp = new BookPanel();
		BookPanel bp2 = new BookPanel();
		
		bp.setLayout(new GridLayout(1,2));
		ArrayList<model.Book> books = reader.getBestSeller();
		bp.setContent(books.get(0));
		bp.setBorder(bestBorder);
		
		bp2.setLayout(new GridLayout(1,2));
		ArrayList<model.Book> books2 = reader.getNewSpecial();
		bp2.setContent(books2.get(0));
		bp2.setBorder(specialBorder);
		
		centerPanel.add(bp);
		centerPanel.add(bp2);
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		
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
