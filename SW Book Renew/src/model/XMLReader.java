package model;
import java.util.ArrayList;

public class XMLReader {

	static private int class_num = 0;
	static private XMLReader rxml;
	private XmlSaxParserHandler xsph;	
	
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
	
	
	public ArrayList<Book> getParseResult(String searchWord, String queryType){	//parsing된 결과 받기
		try {
			xsph.parseXml(URL.GetUrl(searchWord, queryType));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (ArrayList)xsph.Books;
	}
}
