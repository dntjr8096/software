package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import model.XMLReader;

public class NextListener implements ActionListener{

	private XMLReader reader;
	private JTextField field;
	
	public NextListener(XMLReader reader, JTextField field){
		this.reader = reader;
		this.field = field;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(field.getText().isEmpty()){
			System.out.println("검색어없음");	
			return;
		}
		if(e.getActionCommand() == "다음 페이지"){
			reader.addPage();
			reader.getParseResult(field.getText(), "Title", reader.getPage());
		}
		else if(e.getActionCommand() == "이전 페이지"){
			reader.minusPage();
			reader.getParseResult(field.getText(), "Title", reader.getPage());
		}

	}
}
