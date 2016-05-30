package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Book;

import controller.ImageLabelListener;

public class BookPanel extends JPanel{
	
	private JLabel title, author;		//title-제목, author - 저자
	private JPanel bookContent;
	private ImageLabel cover;			//cover - 책표지
	private String link;				//책 상세주소
	
	public BookPanel(){
		setSize(300,180);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		title = new JLabel();
		author = new JLabel();
		bookContent = new JPanel();
		cover = new ImageLabel();
		add(cover, BorderLayout.CENTER);
		bookContent.setLayout(new GridLayout(4,1,0,0));		//gridlayout 2*1생성
		title.setHorizontalAlignment(JLabel.CENTER);
		author.setHorizontalAlignment(JLabel.CENTER);
		
		bookContent.add(new JLabel("제 목", JLabel.CENTER));
		bookContent.add(title);
		bookContent.add(new JLabel("저 자", JLabel.CENTER));
		bookContent.add(author);
		title.setBackground(Color.WHITE);		//Label배경을 White로 설정
		author.setBackground(Color.WHITE);		//Label배경을 White로 설정
		bookContent.setBackground(Color.WHITE);	//Panel배경을 White로 설정

		add(bookContent, BorderLayout.EAST);
	}
	
	
	public void setContent(Book b){ 	//내용 설정 및 리스너 달기
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