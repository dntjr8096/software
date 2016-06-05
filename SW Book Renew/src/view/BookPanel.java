package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
		setLayout(new BorderLayout(0,0));
		
		title = new JLabel();
		author = new JLabel();
		bookContent = new JPanel();
		cover = new ImageLabel();
		
		add(cover, BorderLayout.WEST);
		cover.setPreferredSize(new Dimension(240,280));
		
		bookContent.setLayout(new GridLayout(2,1));		//gridlayout 2*1����
		bookContent.add(title);
		
		//
		title.setVerticalAlignment(JLabel.BOTTOM);
		//author.setVerticalAlignment(JLabel.TOP);
		
		title.setFont(new Font("�������",Font.BOLD,14));
		author.setFont(new Font("�������",Font.BOLD,14));
		
		bookContent.add(author);
		title.setBackground(Color.WHITE);		//Label����� White�� ����
		author.setBackground(Color.WHITE);		//Label����� White�� ����
		bookContent.setBackground(Color.WHITE);	//Panel����� White�� ����

		add(bookContent, BorderLayout.CENTER);
	}
	
	public void setContent(Book b){ 	//���� ����
		title.setText("\n\n    ����:    " + b.Title);
		title.setHorizontalAlignment(JLabel.LEFT);
		author.setText("    ����:    " + b.Author);
		author.setHorizontalAlignment(JLabel.LEFT);
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