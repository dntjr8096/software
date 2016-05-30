package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Book;

import controller.ImageLabelListener;

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
		bookContent.setLayout(new GridLayout(4,1,0,0));		//gridlayout 2*1����
		title.setHorizontalAlignment(JLabel.CENTER);
		author.setHorizontalAlignment(JLabel.CENTER);
		
		bookContent.add(new JLabel("�� ��", JLabel.CENTER));
		bookContent.add(title);
		bookContent.add(new JLabel("�� ��", JLabel.CENTER));
		bookContent.add(author);
		title.setBackground(Color.WHITE);		//Label����� White�� ����
		author.setBackground(Color.WHITE);		//Label����� White�� ����
		bookContent.setBackground(Color.WHITE);	//Panel����� White�� ����

		add(bookContent, BorderLayout.EAST);
	}
	
	
	public void setContent(Book b){ 	//���� ���� �� ������ �ޱ�
		title.setText(b.Title);
		author.setText(b.Author);
		cover.mySetIcon(b.Cover);
		link = b.Link;
		cover.addMouseListener(new ImageLabelListener(link));
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
	
}