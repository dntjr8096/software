package model;

import java.util.ArrayList;

public class User {
	private String id;		//user id
	private String pw;		//user pw
	private ArrayList<Book> books;	//user�� ���� å ���
	
	public User(){		//default ������
		id = null;
		pw = null;
		books = null;
	}
	
	public User(String id, String pw, ArrayList<Book> books){	//id,pw,books �� �޴� ������
		this.id = id;
		this.pw = pw;
		this.books = books;
	}
	
	public void addBook(Book b){		//å �߰�
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
