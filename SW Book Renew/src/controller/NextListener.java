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
		
		if(!reader.getParser().getBooks().isEmpty()){	//å����Ʈ�� ������������� å�˻��Ȱ� 
			isSearched = true;
		}
		if(field.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "�˻�� �Է����ּ���");
			return;
		}
		if(isSearched){
			if(e.getActionCommand() == "���� ������"){
				reader.addPage();
				page.setText(reader.getPage() + " / " + reader.getParser().getTotalPage());
			}
			else if(e.getActionCommand() == "���� ������"){
				reader.minusPage();
				page.setText(reader.getPage() + " / " + reader.getParser().getTotalPage());
			}
			
			if(combo.getSelectedItem().toString() == "����+����")
				reader.getParseResult(field.getText(), "Keyword", reader.getPage());
			else if(combo.getSelectedItem().toString() == "����")
				reader.getParseResult(field.getText(), "Title", reader.getPage());
			else if(combo.getSelectedItem().toString() == "����")
				reader.getParseResult(field.getText(), "Author", reader.getPage());
			else if(combo.getSelectedItem().toString() == "���ǻ�")
				reader.getParseResult(field.getText(), "Publisher", reader.getPage());
		}
	}
}
