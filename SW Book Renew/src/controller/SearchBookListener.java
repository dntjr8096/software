package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Book;
import model.XMLReader;
import view.AddBookFrame;

public class SearchBookListener implements MouseListener{

	private JTextField field;
	private JComboBox combo;
	private JLabel page;
	private XMLReader reader;
	
	//addBookField - addBookFrame에 field
	public SearchBookListener(JTextField addBookField, JComboBox combo, JLabel page, XMLReader xmlr){
		this.field = addBookField;
		this.reader = xmlr;
		this.combo = combo;
		this.page = page;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(field.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "검색어를 입력해주세요");
			return;
		}
		
		if(combo.getSelectedItem().toString() == "제목+저자")
			reader.getParseResult(field.getText(), "Keyword");
		else if(combo.getSelectedItem().toString() == "제목")
			reader.getParseResult(field.getText(), "Title");
		else if(combo.getSelectedItem().toString() == "저자")
			reader.getParseResult(field.getText(), "Author");
		else if(combo.getSelectedItem().toString() == "출판사")
			reader.getParseResult(field.getText(), "Publisher");
		
		reader.resetPage();
		page.setText(reader.getPage() + " / " + reader.getParser().getTotalPage());
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
