package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.database;

public class clearBtnEventHandler implements ActionListener {

	JTextField IDField;
	JTextField PWField;
	database db;
	
	public clearBtnEventHandler(JTextField IDField, JTextField PWField, database db){
		this.IDField = IDField;
		this.PWField = PWField;
		this.db = db;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(db.checkLogin(IDField.getText(), PWField.getText())){
			System.out.println(IDField.getText());
			db.clearBook(IDField.getText());
			JOptionPane.showMessageDialog(null, IDField.getText() + "의 BookList가 초기화 되었습니다.");
		}
		else{
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀렷습니다.");
		}
	}
}
