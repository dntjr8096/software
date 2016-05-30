package model;

// ���� DB�� ��������
// Table : book, user, readingList

// �� attribute
// Table book : ISBN, b_name(å�̸�), author
// Table user : ID, PW
// Table readingList : ID(����), ISBN, reading_date(�б�����ѳ�¥), pages

// UI�� ���� �޼ҵ带 �����Ͽ���,
// �ʿ��� ������ �� �����ϰų�(���ǻ�, ��)
// Ȥ�� �ʿ��� ����� �߰�(����, order), Ȥ�� ����
// �ٷ� ī������ �˷��ּ���. 

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

	public ArrayList<String> getAuthor() { return author; }
	public ArrayList<String> getB_name() { return b_name; }
	public ArrayList<String> getReadingList() { return reading_date; }
	public ArrayList<Integer> getPages() { return pages; }
	
	//	alphabook(DB)�� �ּҸ� �����ϰ�, DB������ ���̵�� ��й�ȣ ����
    public database() {
    	url = "jdbc:mysql://localhost:3306/alphabook";
    	user = "sysdba";
    	pass = "sysdba";
    	author = new ArrayList<String>();
    	b_name = new ArrayList<String>();
    	reading_date = new ArrayList<String>();
    	pages = new ArrayList<Integer>();
    }
    
//  ���α׷� ����� DB�� ���Ῡ�θ� ���캽(����̺�� DB�� ���Ῡ��Ȯ��)
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
	
//	User���̺��� ���ο� ���� �߰�(������ ���̵�� �н�����)
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
	
//	book���̺��� ������ �߰�(ISBN, å�̸�, ����)
	public void addBook(String ISBN, String b_name, String author) {
		try {
			con = DriverManager.getConnection(url,user,pass);
			stat = con.createStatement();
			sql = "insert into book values('"+ISBN+"','"+b_name+"','"+author+"')";
			int checkUp = stat.executeUpdate(sql);
			if(checkUp>0) System.out.println("Success");
			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
//	��������� ������ �߰�(���α׷� �α��ν� ���̵�, å�� ISBN, å�б�����ѳ�¥, ������) 
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
	
//	å�б� �����ѳ�¥ �����ϴ� �޼ҵ�
	public void updateReadingDate(String value, String ID, String ISBN) {
		try {
			con = DriverManager.getConnection(url,user,pass);
			stat = con.createStatement();
			sql = "update readingList set reading_date='"+value+"' where ID='"+ID+"' AND ISBN='"+ISBN+"')" ;
			int checkUp = stat.executeUpdate(sql);
			if(checkUp>0) System.out.println("Success");
			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	�������� ��ġ�� �޼ҵ�
	public void updatePages(int pages, String ID, String ISBN) {
		try {
			con = DriverManager.getConnection(url,user,pass);
			stat = con.createStatement();
			sql = "update readingList set pages='"+pages+"' where ID='"+ID+"' AND ISBN='"+ISBN+"')" ;
			int checkUp = stat.executeUpdate(sql);
			if(checkUp>0) System.out.println("Success");
			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
//	������ �� �迭�� ����
//	����, å�̸�, �б�����ѳ�¥, ��������(���ӵ� id�� ���� ������ ����� ��ϵ��� �ҷ��帲)
	public void getReadingList(String id) {
		sql = "select ID, author, b_name, reading_date, pages from readingList, book where book.ISBN=readingList.ISBN";
		
		try {
			con = DriverManager.getConnection(url,user,pass);
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			int i=0;
			while(rs.next()) {
				String sID = rs.getString(1);
				if(id.equals(sID)) {
					author.add(rs.getString(2));
					b_name.add(rs.getString(3));
					reading_date.add(rs.getString(4));
					pages.add(rs.getInt(5));
//					�� ������ �̸� ����(rs.next()�� ���� �� ���� �� ������ �ڵ����� �������� �̵�)
				} 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	ó�� �α��ν� ���
//	DB�� �ִ� id�� pw�� ��ġ�ѿ��θ� Ȯ���Ͽ� true, false�� ��Ÿ��
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
	
	public void test() {
		System.out.println(getAuthor().get(0)+getB_name().get(0)+getPages().get(0));
	}
	
}