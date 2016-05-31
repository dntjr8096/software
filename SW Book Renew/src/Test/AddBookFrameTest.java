package Test;

import javax.swing.JFrame;

import controller.AddBookListener;
import controller.NextListener;
import controller.SearchBookListener;
import model.User;
import model.XMLReader;
import view.AddBookFrame;

public class AddBookFrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u = new User();
		XMLReader xmlr = XMLReader.newInstance();
		AddBookFrame a = new AddBookFrame(xmlr.getParser());
		SearchBookListener l = new SearchBookListener(a.getField(), xmlr);
		AddBookListener addl = new AddBookListener(u, a.getList(), xmlr);
		NextListener nl = new NextListener(xmlr, a.getField());
		a.setSearchListener(l);
		a.setAddBookListener(addl);
		a.setNextPreListener(nl);
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.pack();
	}

}
