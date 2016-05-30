package view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.Book;

public class MyBookFrame extends JFrame{
	private JButton add, delete;
	private JScrollPane jsp;
	private ArrayList<BookPanel> bookPanels;
	
	public MyBookFrame(){
		add = new JButton("책 추가");
		delete = new JButton("책 삭제");
		bookPanels = new ArrayList<BookPanel>();
		
	}
	
	public void addBooks(ArrayList<Book> books){
		books.
	}
}
