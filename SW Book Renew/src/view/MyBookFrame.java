package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import model.Observer;
import model.Observerable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import model.Book;

public class MyBookFrame extends JFrame implements Observer{
	private JButton add, delete;
	private JScrollPane scroll;
	private JList list;
	private ArrayList<BookPanel> bookPanels;
	private Border border = BorderFactory.createTitledBorder("����å ����Ʈ");
	public MyBookFrame(){
		add = new JButton("å �߰�");
		delete = new JButton("å ����");
		bookPanels = new ArrayList<BookPanel>();
		scroll = new JScrollPane();
		list = new JList();
		setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		add.setSize(100, 50);
		delete.setSize(100, 50);
		buttonPanel.add(add);
		buttonPanel.add(delete);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		 //��ũ�� ����

        scroll.setViewportView(list);
        scroll.setBorder(border); //��� ����
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //���ι���å
        
	}
	
	public void updateBooks(ArrayList<Book> books){
		bookPanels.clear();
		for(Book b: books){		//Books�� �ִ� å bookpanel�� ����� �߰�
			BookPanel bp = new BookPanel();
			bp.setContent(b);
			bookPanels.add(bp);
		}
		list.removeAll();
		for(BookPanel b : bookPanels){
			list.add(b);
		}
	}

	@Override
	public void update(ArrayList<Book> books) {
		updateBooks(books);
	}

	
}
