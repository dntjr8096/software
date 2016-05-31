package model;

// 현재 DB의 구성상태
// Table : book, user, readingList

// 각 attribute
// Table book : ISBN, b_name(책이름), author
// Table user : ID, PW
// Table readingList : ID(유저), ISBN, reading_date(읽기시작한날짜), pages

// UI에 따른 메소드를 구성하였고,
// 필요한 정보를 더 저장하거나(출판사, 판)
// 혹은 필요한 기능을 추가(삭제, order), 혹은 수정
// 바로 카톡으로 알려주세요. 

import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class database {
	private String url;
    private String user;
    private String pass;
    
    private Connection con;
	private Statement stat;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String sql;
	
	private ArrayList<String> author;
	private ArrayList<String> b_name;
	private ArrayList<String> reading_date;
	private ArrayList<Integer> pages;
	private ArrayList<String> link;
	private ArrayList<String> cover;
	private ArrayList<String> ISBN;
	
	public ArrayList<String> getAuthor() { return author; }
	public ArrayList<String> getB_name() { return b_name; }
	public ArrayList<String> getReadingList() { return reading_date; }
	public ArrayList<Integer> getPages() { return pages; }
	public ArrayList<String> getLink()	{ return link; }
	public ArrayList<String> getCover() { return cover; }
	public ArrayList<String> getISBN() { return ISBN; }
	
	//	alphabook(DB)의 주소를 저장하고, DB계정의 아이디와 비밀번호 설정
    public database() {
    	url = "jdbc:mysql://localhost:3306/alphabook";
    	user = "root";
    	pass = "sysdba";
    	author = new ArrayList<String>();
    	b_name = new ArrayList<String>();
    	reading_date = new ArrayList<String>();
    	pages = new ArrayList<Integer>();
    	link = new ArrayList<String>();
    	cover = new ArrayList<String>();
    	ISBN = new ArrayList<String>();
    }
    
//  프로그램 실행시 DB의 연결여부를 살펴봄(드라이브와 DB의 연결여부확인)
	public void checkDB() {
		 try{
	         Class.forName("org.gjt.mm.mysql.Driver");
	         System.out.println("completed");
	      } catch(ClassNotFoundException e) {
	         System.out.println("Failed");
	      }
	      
	     
	      try {
	         con = DriverManager.getConnection(url,user,pass);
	         System.out.println("MySQL Connected");
	      }catch(SQLException e) {
	         System.out.println("MySQL not Connected");
	      }
	}
	
//	User테이블의 새로운 값을 추가(유저의 아이디와 패스워드)
	public void addUser(String id, String pw) {
		try {
			con = DriverManager.getConnection(url,user,pass);
			stat = con.createStatement();
			sql = "insert into user values('"+id+"','"+pw+"')";
			int checkUp = stat.executeUpdate(sql);
			if(checkUp>0) System.out.println("Success");
			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	book테이블의 값들을 추가(ISBN, 책이름, 저자)
	public void addBook(String ISBN, String b_name, String author, String link, String cover ) {
		try {
			con = DriverManager.getConnection(url,user,pass);
			stat = con.createStatement();
			sql = "insert into book values('"+ISBN+"','"+b_name+"','"+author+"','"+link+"','"+cover+"')";
			int checkUp = stat.executeUpdate(sql);
			if(checkUp>0) System.out.println("Success");
			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
//	독서기록의 값들을 추가(프로그램 로그인시 아이디, 책의 ISBN, 책읽기시작한날짜, 페이지) 
	public void addReadingList(String ID, String ISBN, String reading_date, int pages) {
		try {
			con = DriverManager.getConnection(url,user,pass);
			stat = con.createStatement();
			sql = "insert into readingList values('"+ID+"','"+ISBN+"','"+reading_date+"',"+pages+")";
			int checkUp = stat.executeUpdate(sql);
			if(checkUp>0) System.out.println("Success");
			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	책읽기 시작한날짜 수정하는 메소드
	public void updateReadingDate(String value, String ID, String ISBN) {
		try {
			con = DriverManager.getConnection(url,user,pass);
			stat = con.createStatement();
			sql = "update readingList set reading_date='"+value+"' where ID='"+ID+"' AND ISBN='"+ISBN+"'" ;
			int checkUp = stat.executeUpdate(sql);
			if(checkUp>0) System.out.println("Success");
			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	페이지를 고치는 메소드
	public void updatePages(int pages, String ID, String ISBN) {
		try {
			con = DriverManager.getConnection(url,user,pass);
			stat = con.createStatement();
			sql = "update readingList set pages='"+pages+"' where ID='"+ID+"' AND ISBN='"+ISBN+"'" ;
			int checkUp = stat.executeUpdate(sql);
			if(checkUp>0) System.out.println("Success");
			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteBook(String ID, String b_name) {
		sql = "delete from readingList where ID=? AND b_name=?";
		try {
			con = DriverManager.getConnection(url,user,pass);
			ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, ID);
			ps.setString(2, b_name);
			int checkUp = ps.executeUpdate();
			if(checkUp>0) System.out.println("Success");
			else System.out.println("Failed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void clearBook(String ID) {
		sql = "delete from readingList where ID=?";
		try {
			con = DriverManager.getConnection(url,user,pass);
			ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, ID);
			int checkUp = ps.executeUpdate();
			if(checkUp>0) System.out.println("Success");
			else System.out.println("Failed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//check ID
	public boolean checkID(String id) {
		boolean check = false;
		sql = "select ID from user";
		try {
			con = DriverManager.getConnection(url,user,pass);
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while(rs.next()) {
				String sID = rs.getString(1);
				if(id.equals(sID)) {
					check = true;
				}
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	
//	값들을 각 배열에 저장
//	저자, 책이름, 읽기시작한날짜, 페이지수(접속된 id의 값을 가지고 저장된 기록들을 불러드림)
	/*public void getReadingList(String id) {
		sql = "select ID, author, b_name, reading_date, pages from readingList, book where book.ISBN=readingList.ISBN";
		
		try {
			con = DriverManager.getConnection(url,user,pass);
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String sID = rs.getString(1);
				if(id.equals(sID)) {
					author.add(rs.getString(2));
					b_name.add(rs.getString(3));
					reading_date.add(rs.getString(4));
					pages.add(rs.getInt(5));
//					각 변수에 이를 저장(rs.next()로 인해 한 행을 다 읽으면 자동으로 다음열로 이동)
				} 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
//	처음 로그인시 사용
//	DB의 있는 id와 pw가 일치한여부를 확인하여 true, false로 나타냄
//	ex) LoginEventHandler : if (event.equals("OK") && db.checkLogin(ID, PW))
	public boolean checkLogin(String id, String pw) {
		boolean check = false;
		sql = "select * from user";
		try {
			con = DriverManager.getConnection(url,user,pass);
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while(rs.next()) {
				String sID = rs.getString("ID");
				if(id.equals(sID)) {
					String sPW = rs.getString("PW");
					if(pw.equals(sPW)) check = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public ArrayList<Book> getAllData(String id) {
		sql = "select ID,b_name,link,author,cover,book.ISBN,pages,reading_date from readingList,book";
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			con = DriverManager.getConnection(url,user,pass);
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String sID = rs.getString(1);
				if(id.equals(sID)) {
					Book book = new Book();
//					b_name.add(rs.getString(2));
//					link.add(rs.getString(3));
//					author.add(rs.getString(4));
//					cover.add(rs.getString(5));
//					ISBN.add(rs.getString(6));
//					pages.add(rs.getInt(7));
//					reading_date.add(rs.getString(8));
//					각 변수에 이를 저장(rs.next()로 인해 한 행을 다 읽으면 자동으로 다음열로 이동)
					book.Title = rs.getString(2);
					book.Link = rs.getString(3);
					book.Author = rs.getString(4);
					book.Cover = rs.getString(5);
					book.ISBN = rs.getString(6);
					book.setPage(rs.getInt(7));
					books.add(book);
				} 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

}


