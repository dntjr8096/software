package model;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;

class XmlSaxParserHandler extends DefaultHandler implements Observerable{
	public List<Book> Books;
	private Book currentBook;
	private boolean inItemElement = false;
	private String tempValue;
	private ArrayList<Observer> observers;
	
	public XmlSaxParserHandler( ){			//������
		Books = new ArrayList<Book>();
		observers = new ArrayList<Observer>();
	}

	public void startElement(String namespace, String localName, String qName, Attributes atts) {	//���� element������ ����
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
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException{
		tempValue = tempValue + new String(ch,start,length);
	}

	public void endElement(String namespaceURI, String localName,String qName) {	// ������ element�������� ����
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
	}

	public void parseXml(String xmlUrl) throws Exception {		//xml parsing
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            ParserAdapter pa = new ParserAdapter(sp.getParser());
            pa.setContentHandler(this);
			pa.parse(xmlUrl);
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
            observer.update((ArrayList)Books);   // update�� ���������� �����Ѵ�.
        }
    }
}