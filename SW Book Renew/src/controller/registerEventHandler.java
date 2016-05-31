package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.database;

public class registerEventHandler implements ActionListener {
	
	JTextField IDField, PWField;
	database db;
	
	public registerEventHandler(JTextField IDField, JTextField PWField, database db){
		this.IDField = IDField;
		this.PWField = PWField;
		this.db = db;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(db.checkID(IDField.getText())){
			JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다.");	
		}
		else{
			db.addUser(IDField.getText(), PWField.getText());
			JOptionPane.showMessageDialog(null, "등록완료");
		}
	}

}
