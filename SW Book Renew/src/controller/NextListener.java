package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.XMLReader;

public class NextListener implements ActionListener{

	private XMLReader reader;
	private JTextField field;
	private JLabel page;
	private JComboBox combo;
	private boolean isSearched = false;
	
	public NextListener(XMLReader reader, JTextField field, JLabel page, JComboBox combo){
		this.reader = reader;
		this.field = field;
		this.page = page;
		this.combo = combo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(!reader.getParser().getBooks().isEmpty()){	//책리스트가 비어있지않으면 책검색된것 
			isSearched = true;
		}
		if(field.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "검색어를 입력해주세요");
			return;
		}
		if(isSearched){
			if(e.getActionCommand() == "다음 페이지"){
				reader.addPage();
				page.setText(reader.getPage() + " / " + reader.getParser().getTotalPage());
			}
			else if(e.getActionCommand() == "이전 페이지"){
				reader.minusPage();
				page.setText(reader.getPage() + " / " + reader.getParser().getTotalPage());
			}
			
			if(combo.getSelectedItem().toString() == "제목+저자")
				reader.getParseResult(field.getText(), "Keyword", reader.getPage());
			else if(combo.getSelectedItem().toString() == "제목")
				reader.getParseResult(field.getText(), "Title", reader.getPage());
			else if(combo.getSelectedItem().toString() == "저자")
				reader.getParseResult(field.getText(), "Author", reader.getPage());
			else if(combo.getSelectedItem().toString() == "출판사")
				reader.getParseResult(field.getText(), "Publisher", reader.getPage());
		}
	}
}
