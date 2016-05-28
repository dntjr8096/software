package model;
import java.sql.*;

public class database {
	private Statement stat;
	private Connection con = null;
	private String sql;
	
	public void checkDB() {
		 try{
	         Class.forName("org.gjt.mm.mysql.Driver");
//	         System.out.println("completed");
	      } catch(ClassNotFoundException e) {
//	         System.out.println("Failed");
	      }
	      
	      String url = "jdbc:mysql://localhost:3306/alphabook";
	      String user = "sysdba";
	      String pass = "oracle";
	      try {
	         con = DriverManager.getConnection(url,user,pass);
//	         System.out.println("MySQL Connected");
	      }catch(SQLException e) {
//	         System.out.println("MySQL not Connected");
	      }
	}
	
	public void addUser(String id, String pw) {
		try {
			stat = con.createStatement();
			sql = "insert into user values('"+id+"','"+pw+"')";
			int checkUp = stat.executeUpdate(sql);
//			if(checkUp>0) System.out.println("Success");
//			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addBook(String ISBN, String b_name, String author) {
		try {
			stat = con.createStatement();
			sql = "insert into book values('"+ISBN+"','"+b_name+"','"+author+"')";
			int checkUp = stat.executeUpdate(sql);
//			if(checkUp>0) System.out.println("Success");
//			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void addReadingList(String ID, String ISBN, String reading_date, int pages) {
		try {
			stat = con.createStatement();
			sql = "insert into readingList values('"+ID+"','"+ISBN+"','"+reading_date+"',"+pages+")";
			int checkUp = stat.executeUpdate(sql);
//			if(checkUp>0) System.out.println("Success");
//			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateReadingList(String value, String col, String ID, String ISBN) {
		try {
			stat = con.createStatement();
			sql = "update readingList set "+col+"='"+value+"' where ID='"+ID+"' AND ISBN='"+ISBN+"')" ;
			int checkUp = stat.executeUpdate(sql);
//			if(checkUp>0) System.out.println("Success");
//			else System.out.println("Failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewReadingList() {
		PreparedStatement preSt = null;
		ResultSet result = null;
		sql = "select author, b_name, reading_date, pages from readingList, book where book.ISBN=readingList.ISBN";
	
		try {
			preSt = con.prepareStatement(sql);
			result = preSt.executeQuery();
			while(result.next()) {
				String author = result.getString(1);
				String b_name = result.getString(2);
				String reading_date = result.getString(3);
				int pages = result.getInt(4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

