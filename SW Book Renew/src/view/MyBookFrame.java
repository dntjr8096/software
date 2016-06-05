package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import model.Observer;
import model.Observerable;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
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
	//private ArrayList<BookPanel> bookPanels;
	private Border border = BorderFactory.createTitledBorder("나의책 리스트");
	private Observerable observerable;
	private DefaultListModel model = new DefaultListModel();
	
	public MyBookFrame(Observerable obs){
		observerable = obs;
		observerable.addObserver(this);
		
		add = new JButton("책 리스트 추가");
		delete = new JButton("책 삭제");
		//bookPanels = new ArrayList<BookPanel>();
		scroll = new JScrollPane();
		list = new JList();
		//scroll.setSize(1600,1000);
		//list.setPreferredSize(new Dimension(1600,1000));
		
		setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		add.setSize(100, 50);
		delete.setSize(100, 50);
		buttonPanel.add(add);
		buttonPanel.add(delete);
		add(buttonPanel, BorderLayout.NORTH);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(new BookRenderer());
		list.setModel(model); 
		//스크롤 셋팅

        scroll.setViewportView(list);
        scroll.setBorder(border); //경계 설정
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //가로바정책
        
        getContentPane().add(scroll, BorderLayout.CENTER);
        setVisible(true);
        
        Container ct = this.getContentPane();
        
        ct.setPreferredSize(new Dimension(1600,800));
		
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
	}
	
	public void updateBooks(ArrayList<Book> books){
//		bookPanels.clear();
//		for(Book b: books){		//Books에 있는 책 bookpanel로 만들고 추가
//			BookPanel bp = new BookPanel();
//			bp.setContent(b);
//			bookPanels.add(bp);
//		}
		
		model.clear();
			
		for(Book b : books){
			BookPanel bp = new BookPanel();
			bp.setContent(b);
			model.addElement(bp);
		}
	}

	@Override
	public void update(ArrayList<Book> books) {
		updateBooks(books);
	}

	//각 버튼에 리스너 추가
	public void setAddButtonListener(MouseListener l){
		add.addMouseListener(l);
	}
	
	public void setDeleteButtonListener(MouseListener l){
		delete.addMouseListener(l);
	}
	
	public JList getList(){
		return list;
	}
}
