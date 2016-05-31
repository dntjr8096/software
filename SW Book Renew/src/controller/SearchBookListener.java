package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import model.Book;
import model.XMLReader;
import view.AddBookFrame;

public class SearchBookListener implements MouseListener{

	private JTextField field;
	private XMLReader reader;
	
	//addBookField - addBookFrame¿¡ field
	public SearchBookListener(JTextField addBookField, XMLReader xmlr){
		this.field = addBookField;
		this.reader = xmlr;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		reader.getParseResult(field.getText(), "Title");
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
