package controller;
import model.Book;
import model.User;

public class AddBook implements CommandProcess{

	private User user;
	private Book b;
	
	public AddBook(User user, Book b){
		this.user = user;
		this.b = b;
	}
	
	@Override
	public void doAction() {
		
		user.addBook(b);
		// TODO Auto-generated method stub
		
	}	//CommandProcess 인터페이스 상속
	
}
