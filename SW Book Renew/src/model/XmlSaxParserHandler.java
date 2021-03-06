package model;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;

public class XmlSaxParserHandler extends DefaultHandler implements Observerable{
	public List<Book> Books;
	private Book currentBook;
	private boolean inItemElement = false;
	private String tempValue;
	private ArrayList<Observer> observers;
	private int totalResults = 0;
	
	public XmlSaxParserHandler( ){			//생성자
		Books = new ArrayList<Book>();
		observers = new ArrayList<Observer>();
	}

	public void startElement(String namespace, String localName, String qName, Attributes atts) {	//시작 element만날시 실행
		if (localName.equals("item")) {
			currentBook = new Book();
			inItemElement = true;
		} else if (localName.equals("title")) {
			tempValue = "";
		} else if (localName.equals ("link")) {
			tempValue = "";
		} else if (localName.equals("author")) {
			tempValue = "";
		} else if (localName.equals("isbn")) {
			tempValue = "";
		} else if (localName.equals("cover")) {
			tempValue = "";
		}
		
		if(localName.equals("totalResults")){
			tempValue = "";
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException{
		tempValue = tempValue + new String(ch,start,length);
	}

	public void endElement(String namespaceURI, String localName,String qName) {	// 마지막 element만났을때 실행
		if(inItemElement){
			if (localName.equals("item")) {
				Books.add(currentBook);
				currentBook = null;
				inItemElement = false;
			} else if (localName.equals("title")) {
				currentBook.Title = tempValue;
			} else if (localName.equals("link")) {
				currentBook.Link = tempValue;
			} else if (localName.equals("author")) {
				currentBook.Author = tempValue;
			} else if (localName.equals("isbn")) {
				currentBook.ISBN = tempValue;
			} else if (localName.equals("cover")) {
				currentBook.Cover = tempValue;
			}
		}
		
		if(localName.equals("totalResults")){
			totalResults = Integer.parseInt(tempValue);
		}
	}

	public void parseXml(String xmlUrl) throws Exception {		//xml parsing
            Books.clear();
			SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            ParserAdapter pa = new ParserAdapter(sp.getParser());
            pa.setContentHandler(this);
			pa.parse(xmlUrl);
	}
	
	public int getTotalPage(){
		return (int)Math.ceil(((double)totalResults/10.0));
	}
	
	public ArrayList<Book> getBooks(){
		return (ArrayList)Books;
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
            observer.update((ArrayList)Books);   // update로 옵저버에게 전달한다.
        }
    }
}