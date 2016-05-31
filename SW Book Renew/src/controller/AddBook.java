package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Book;
import model.User;

public class AddBook implements ActionListener{

	private User user;
	
	public AddBook(User user){
		this.user = user;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		user.addBook(b);
	}
	
	
	
}
