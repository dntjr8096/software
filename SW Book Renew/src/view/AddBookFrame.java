package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import model.Book;
import model.Observer;
import model.Observerable;

public class AddBookFrame extends JFrame implements Observer{
	private JButton add, search;
	private JTextField field;
	private JScrollPane scroll;
	private JList list;
	private Border border = BorderFactory.createTitledBorder("책 검색결과");
	private Observerable observerable;
	
	public AddBookFrame(Observerable obs){
		observerable = obs;
		observerable.addObserver(this);
		
		setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		add = new JButton("추가");
		search = new JButton("검색");
		field = new JTextField(30);
		buttonPanel.add(add);
		buttonPanel.add(field);
		buttonPanel.add(search);
		add(buttonPanel, BorderLayout.NORTH);
		
		list = new JList();
		scroll = new JScrollPane();
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(new BookRenderer());
		 //스크롤 셋팅

        scroll.setViewportView(list);
        scroll.setBorder(border); //경계 설정
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //가로바정책
        
        getContentPane().add(scroll, BorderLayout.CENTER);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
	}
	@Override
	public void update(ArrayList<Book> books) {
		// TODO Auto-generated method stub
		list.removeAll();
		//vector에 books안에있는 책들 추가 후 list에 set	
		Vector vec = new Vector();
		for(Book b : books){
			vec.add(b);
		}
		list.setListData(vec);
		pack();
	}

	public JTextField getField(){
		return field;
	}
	
	public JList getList(){
		return list;
	}
	
	public void setSearchListener(MouseListener l){
		search.addMouseListener(l);
	}
	
	public void setAddBookListener(MouseListener l){
		add.addMouseListener(l);
	}
}
