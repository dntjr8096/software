package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JList;

import model.Book;
import model.User;
import model.XMLReader;

public class AddBookListener implements MouseListener{

	private User user;
	private JList list;
	private XMLReader reader;
	
	//addBookList - addBookFrame에 List
	public AddBookListener(User user, JList addBookList, XMLReader reader){
		this.user = user;
		this.list = addBookList;
		this.reader = reader;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//리스트에서 선택된 책을 추가
		ArrayList<Book> books = reader.getParser().getBooks();
		user.addBook(books.get(list.getSelectedIndex()));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
