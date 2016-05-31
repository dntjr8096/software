package model;
import java.util.ArrayList;

public class XMLReader {

	static private int class_num = 0;
	static private XMLReader rxml;
	private XmlSaxParserHandler xsph;	
	private int page = 1;
	
	private XMLReader(){
		xsph = new XmlSaxParserHandler();
	}
	
	public static XMLReader newInstance(){
		if(class_num == 0){
			rxml = new XMLReader();
			class_num++;
			return rxml;
		}
		else{
			return rxml;
		}
	}
	
	public ArrayList<Book> getBestSeller(){
		try {
			xsph.parseXml(URL.GetUrl2());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ArrayList<Book>) xsph.Books;
	}
	
	public ArrayList<Book> getParseResult(String searchWord, String queryType){	//parsing된 결과 받기
		try {
			xsph.parseXml(URL.GetUrl(searchWord, queryType));
			xsph.notifyObservers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (ArrayList)xsph.Books;
	}
	
	public ArrayList<Book> getParseResult(String searchWord, String queryType, int page){	//parsing된 결과 받기
		try {
			xsph.parseXml(URL.GetUrl(searchWord, queryType, page));
			xsph.notifyObservers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (ArrayList)xsph.Books;
	}
	
	public XmlSaxParserHandler getParser(){
		return xsph;
	}
	
	public int getPage(){
		return page;
	}
	
	public void addPage(){
		page++;
	}
	
	public void minusPage(){
		if(page >=1)
				page--;
	}
	
}
