package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

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
	private Border border = BorderFactory.createTitledBorder("å �˻����");
	private Observerable observerable;
	
	public AddBookFrame(Observerable obs){
		observerable = obs;
		observerable.addObserver(this);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		add = new JButton("�߰�");
		search = new JButton("�˻�");
		field = new JTextField();
		list = new JList();
		scroll = new JScrollPane();
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(new BookRenderer());
		 //��ũ�� ����

        scroll.setViewportView(list);
        scroll.setBorder(border); //��� ����
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //���ι���å
        
        getContentPane().add(scroll, BorderLayout.CENTER);
        pack();
	}
	@Override
	public void update(ArrayList<Book> books) {
		// TODO Auto-generated method stub
		
	}

}
