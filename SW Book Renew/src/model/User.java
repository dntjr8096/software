package model;

import java.util.ArrayList;
import model.Observer;

public class User implements Observerable{
	private String id;		//user id
	private String pw;		//user pw
	private ArrayList<Book> books;	//user�� ���� å ���
	private ArrayList<Observer> observers;	//observer����Ʈ
	
	public User(){		//default ������
		id = null;
		pw = null;
		books = new ArrayList<Book>();
		observers = new ArrayList<Observer>();
	}
	
	public User(String id, String pw, ArrayList<Book> books){	//id,pw,books �� �޴� ������
		this.id = id;
		this.pw = pw;
		this.books = books;
		observers = new ArrayList<Observer>();
	}
	
	public void addBook(Book b){		//å �߰�
		books.add(b);
		notifyObservers();
	}
	
	public void deleteBook(int index){
		books.remove(index);
		notifyObservers();
	}
	//������ �߰�
	public void addObserver(Observer o){
		observers.add(o);
	}
	
    // ������ ����
    public void deleteObserver(Observer o){            
        int i = observers.indexOf(o);                
        if(i>=0){
            observers.remove(i);
        }
    }
    
    // �������� ������ ����
    public void notifyObservers(){                            
        for(int i=0; i<observers.size(); i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(books);   // update�� ���������� �����Ѵ�.
        }
    }
    
	public String getID(){	//id getter
		return id;
	}
	
	public String getPW(){	//pw getter
		return pw;	
	}
	
	public void inputID(String ID){
		id = ID;
	}
	
	public void inputPW(String PW){
		pw = PW;
	}
	
	public void inputBooks(ArrayList<Book> Books){
		books = Books;
	}
	
	public ArrayList<Book> getBooks(){	//books getter
		return books;
	}


}
