package model;

import java.util.ArrayList;

public class User {
	private String id;		//user id
	private String pw;		//user pw
	private ArrayList<Book> books;	//user가 읽은 책 목록
	
	public User(){		//default 생성자
		id = null;
		pw = null;
		books = null;
	}
	
	public User(String id, String pw, ArrayList<Book> books){	//id,pw,books 를 받는 생성자
		this.id = id;
		this.pw = pw;
		this.books = books;
	}
	
	public void addBook(Book b){		//책 추가
		books.add(b);
	}
	
	public String getID(){	//id getter
		return id;
	}
	
	public String getPW(){	//pw getter
		return pw;	
	}
	
	public ArrayList<Book> getBooks(){	//books getter
		return books;
	}
}
