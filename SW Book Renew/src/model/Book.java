package model;

public class Book{
	public String Title = "";	//제목
	public String Link = "";	//책 판매 링크 -> 알라딘으로 이동	
	public String Author = "";	//저자
	public String Cover = "";	//책표지 이미지 주소
	public String ISBN = "";	//책 고유번호 ISBN
	public String price = "";	//책 가격
	private int page = 0;		//지금까지 읽은 페이지 수
	
	public void setPage(int page){	//읽은 .페이지 설정
		this.page = page;
	}
}