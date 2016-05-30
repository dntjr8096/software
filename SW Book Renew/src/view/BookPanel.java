package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Book;

public class BookPanel extends JPanel{
	
	private JLabel title, author;		//title-제목, author - 저자
	private ImageLabel cover;			//cover - 책표지
	private String link;				//책 상세주소
	
	public BookPanel(){
		setSize(150,240);
		setLayout();
	}
	
	public void setContent(Book b){ 	//내용 설정
		title.setText(b.Title);
		author.setText(b.Author);
		cover.mySetIcon(b.Cover);
		link = b.Link;
	}
}