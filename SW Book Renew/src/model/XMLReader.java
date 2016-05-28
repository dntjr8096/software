package model;

public class XMLReader {

	static private int class_num = 0;
	static private XMLReader rxml;
	private String searchWord, queryType;
	
	private XMLReader(){
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
	
	public void setSearchWord(String searchWord){
		this.searchWord = searchWord;
	}
	
	public void setQueryType(String queryType){
		this.queryType = queryType;
	}
	
	
}
