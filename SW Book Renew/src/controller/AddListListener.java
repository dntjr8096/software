package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.User;
import model.XMLReader;
import view.AddBookFrame;

public class AddListListener implements MouseListener{

	private AddBookFrame abf;
	private XMLReader reader; 
	private User user;
	
	public AddListListener(XMLReader reader, User user){
		this.reader = reader;
		this.user = user;
	}
	@Override
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.abf = new AddBookFrame(reader.getParser());
		abf.setAddBookListener(new AddBookListener(user, abf.getList(), reader));
		abf.setSearchListener(new SearchBookListener(abf.getField(),abf.getComboBox(),abf.getPageLabel() ,reader));
		abf.setNextPreListener(new NextListener(reader, abf.getField(), abf.getPageLabel(), abf.getComboBox()));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
