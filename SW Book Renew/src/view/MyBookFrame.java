package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import model.Observer;
import model.Observerable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Book;

public class MyBookFrame extends JFrame implements Observer{
	private JButton add, delete;
	private JScrollPane jsp;
	private ArrayList<BookPanel> bookPanels;
	
	public MyBookFrame(){
		add = new JButton("책 추가");
		delete = new JButton("책 삭제");
		bookPanels = new ArrayList<BookPanel>();
		setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		add.setSize(100, 50);
		delete.setSize(100, 50);
		buttonPanel.add(add);
		buttonPanel.add(delete);
		
	}
	
	public void addBooks(ArrayList<Book> books){
		for(Book b: books){
			BookPanel bp = new BookPanel();
			bp.setContent(b);
			bookPanels.add(bp);
		}
	}

	@Override
	public void update(ArrayList<Book> books) {
		addBooks(books);
		
	}

	
}
