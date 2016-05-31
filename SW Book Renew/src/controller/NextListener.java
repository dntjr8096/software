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
			System.out.println("�˻������");	
			return;
		}
		if(e.getActionCommand() == "���� ������"){
			reader.addPage();
			reader.getParseResult(field.getText(), "Title", reader.getPage());
		}
		else if(e.getActionCommand() == "���� ������"){
			reader.minusPage();
			reader.getParseResult(field.getText(), "Title", reader.getPage());
		}

	}
}
