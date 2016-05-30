package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Book;

public class BookPanel extends JPanel{
	
	private JLabel title, author;		//title-����, author - ����
	private ImageLabel cover;			//cover - åǥ��
	private String link;				//å ���ּ�
	
	public BookPanel(){
		setSize(150,240);
		setLayout();
	}
	
	public void setContent(Book b){ 	//���� ����
		title.setText(b.Title);
		author.setText(b.Author);
		cover.mySetIcon(b.Cover);
		link = b.Link;
	}
}