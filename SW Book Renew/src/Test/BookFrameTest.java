package Test;

import java.util.ArrayList;

import javax.swing.JFrame;

import model.Book;
import model.User;
import model.XMLReader;
import view.BookPanel;
import view.MyBookFrame;

public class BookFrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMLReader xmlr = XMLReader.newInstance();
		ArrayList<Book> books = xmlr.getParseResult("소프트웨어공학", "Title");
		User u = new User("id", "pw", books);
		MyBookFrame jf = new MyBookFrame(u);
		jf.updateBooks(books);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.pack();
			
	}

}
