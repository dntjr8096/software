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
		add = new JButton("å �߰�");
		delete = new JButton("å ����");
		bookPanels = new ArrayList<BookPanel>();
		
	}
	
	public void addBooks(ArrayList<Book> books){
		books.
	}
}
