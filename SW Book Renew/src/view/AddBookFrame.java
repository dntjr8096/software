package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
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
	private JButton next, previous;
	private JTextField field;
	private JScrollPane scroll;
	private JList list;
	private Border border = BorderFactory.createTitledBorder("å �˻����");
	private Observerable observerable;
	private DefaultListModel model = new DefaultListModel();
	
	public AddBookFrame(Observerable obs){
		observerable = obs;
		observerable.addObserver(this);
		
		Container ct = this.getContentPane();
	    ct.setPreferredSize(new Dimension(1600,800));
	    
		setLayout(new BorderLayout());
		next = new JButton("���� ������");
		previous = new JButton("���� ������");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(previous);
		buttonPanel.add(next);
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		add = new JButton("�߰�");
		search = new JButton("�˻�");
		field = new JTextField(30);
		buttonPanel2.add(add);
		buttonPanel2.add(field);
		buttonPanel2.add(search);
		add(buttonPanel, BorderLayout.SOUTH);
		add(buttonPanel2, BorderLayout.NORTH);
		
		list = new JList();
		scroll = new JScrollPane();
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(new BookRenderer());
		list.setModel(model); 
		//��ũ�� ����

        scroll.setViewportView(list);
        scroll.setBorder(border); //��� ����
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //���ι���å
        
        getContentPane().add(scroll, BorderLayout.CENTER);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	@Override
	public void update(ArrayList<Book> books) {
		// TODO Auto-generated method stub
		//list.removeAll();
		model.clear();
		//vector�� books�ȿ��ִ� å�� �߰� �� list�� set	
		for(Book b : books){
			BookPanel bp = new BookPanel();
			bp.setContent(b);
			model.addElement(bp);
		}
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
	
	public void setNextPreListener(ActionListener l){
		next.addActionListener(l);
		previous.addActionListener(l);
	}
}
