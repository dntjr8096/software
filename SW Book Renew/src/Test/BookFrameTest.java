package Test;

import java.util.ArrayList;

import javax.swing.JFrame;

import model.Book;
import model.XMLReader;
import view.BookPanel;

public class BookFrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame();
		BookPanel bp = new BookPanel();
		XMLReader xmlr = XMLReader.newInstance();
		ArrayList<Book> books = xmlr.getParseResult("프로그래밍", "Title");
		jf.add(bp);
		bp.setContent(books.get(1));
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
	}

}
