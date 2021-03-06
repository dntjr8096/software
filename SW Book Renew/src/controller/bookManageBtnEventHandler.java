package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.User;
import model.XMLReader;
import view.MyBookFrame;

public class bookManageBtnEventHandler implements MouseListener {

	private User user;
	private MyBookFrame mbf;
	private XMLReader reader;
	
	public bookManageBtnEventHandler(User user, XMLReader reader){
		this.user = user;
		this.reader = reader;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mbf = new MyBookFrame(user);
		mbf.setDeleteButtonListener(new DeleteBookListener(user, mbf.getList()));
		mbf.update(user.getBooks());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
