package model;

import java.util.ArrayList;
import model.Observer;

public class User implements Observerable{
	private String id;		//user id
	private String pw;		//user pw
	private ArrayList<Book> books;	//user가 읽은 책 목록
	private ArrayList<Observer> observers;	//observer리스트
	
	public User(){		//default 생성자
		id = null;
		pw = null;
		books = null;
		observers = new ArrayList<Observer>();
	}
	
	public User(String id, String pw, ArrayList<Book> books){	//id,pw,books 를 받는 생성자
		this.id = id;
		this.pw = pw;
		this.books = books;
		observers = new ArrayList<Observer>();
	}
	
	public void addBook(Book b){		//책 추가
		books.add(b);
		notifyObservers();
	}
	
	//옵저버 추가
	public void addObserver(Observer o){
		observers.add(o);
	}
	
    // 옵저버 제거
    public void deleteObserver(Observer o){            
        int i = observers.indexOf(o);                
        if(i>=0){
            observers.remove(i);
        }
    }
    
    // 옵저버에 데이터 전달
    public void notifyObservers(){                            
        for(int i=0; i<observers.size(); i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(books);   // update로 옵저버에게 전달한다.
        }
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
