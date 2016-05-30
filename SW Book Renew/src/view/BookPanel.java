package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.ImageLabelListener; 

import model.Book;

public class BookPanel extends JPanel{
	
	private JLabel title, author;		//title-����, author - ����
	private JPanel bookContent;
	private ImageLabel cover;			//cover - åǥ��
	private String link;				//å ���ּ�
	
	public BookPanel(){
		setSize(300,180); 		
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		title = new JLabel();
		author = new JLabel();
		bookContent = new JPanel();
		cover = new ImageLabel();
		
		add(cover, BorderLayout.CENTER);
		
		bookContent.setLayout(new GridLayout(2,1));		//gridlayout 2*1����
		bookContent.add(title);
		bookContent.add(author);
		title.setBackground(Color.WHITE);		//Label����� White�� ����
		author.setBackground(Color.WHITE);		//Label����� White�� ����
		bookContent.setBackground(Color.WHITE);	//Panel����� White�� ����

		add(bookContent, BorderLayout.EAST);
	}
	
	public void setContent(Book b){ 	//���� ����
		title.setText(b.Title);
		author.setText(b.Author);
		cover.mySetIcon(b.Cover);
		link = b.Link;
	}
	//getter
	public JLabel getTitle(){
		return title;
	}
	
	public JLabel getAuthor(){
		return author;
	}
	
	public ImageLabel getCover(){
		return cover;
	}
	
	public JPanel getbookContent(){
		return bookContent;
	}
	
}