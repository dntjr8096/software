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
	
	private JLabel title, author, title2, author2;		//title-제목, author - 저자
	private JPanel bookContent;
	private ImageLabel cover;			//cover - 책표지
	private String link;				//책 상세주소
	
	public BookPanel(){
		setSize(300,180); 		
		setLayout(new BorderLayout(0,0));
		
		title = new JLabel();
		title2 = new JLabel();
		author = new JLabel();
		author2 = new JLabel();
		bookContent = new JPanel();
		cover = new ImageLabel();
		
		add(cover, BorderLayout.WEST);
		cover.setPreferredSize(new Dimension(240,280));
		
		bookContent.setLayout(new GridLayout(4,1));		//gridlayout 2*1생성
		bookContent.add(title);
		bookContent.add(title2);
		
		//
		title.setVerticalAlignment(JLabel.BOTTOM);
		//author.setVerticalAlignment(JLabel.TOP);
		
		title.setFont(new Font("나눔고딕",Font.BOLD,14));
		title2.setFont(new Font("나눔고딕",Font.BOLD,14));
		author.setFont(new Font("나눔고딕",Font.BOLD,14));
		author2.setFont(new Font("나눔고딕",Font.BOLD,14));
		
		
		
		bookContent.add(author);
		bookContent.add(author2);
		
		title.setBackground(Color.WHITE);		//Label배경을 White로 설정
		author.setBackground(Color.WHITE);		//Label배경을 White로 설정
		bookContent.setBackground(Color.WHITE);	//Panel배경을 White로 설정

		add(bookContent, BorderLayout.CENTER);
	}
	
	public void setContent(Book b){ 	//내용 설정
		
		String titleString = new String(b.Title);
		String authorString = new String(b.Author);
		
		if(titleString.length() < 14){
			title.setText("\n\n    제목:    " + titleString);
		}
		else{
			title.setText("\n\n    제목:    " + titleString.substring(0, 13));
			title2.setHorizontalAlignment(JLabel.LEFT);
			title2.setText("               " + titleString.substring(13, titleString.length()));
		}
		title.setHorizontalAlignment(JLabel.LEFT);
		
		if(authorString.length() < 14){
			author.setText("    저자:    " + authorString);
		}
		else{
			author.setText("\n\n    저자:    " + authorString.substring(0, 13));
			author2.setHorizontalAlignment(JLabel.LEFT);
			author2.setText("               " + authorString.substring(13, authorString.length()));
		}
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