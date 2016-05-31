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
			JOptionPane.showMessageDialog(null, IDField.getText() + "�� BookList�� �ʱ�ȭ �Ǿ����ϴ�.");
		}
		else{
			JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� Ʋ�ǽ��ϴ�.");
		}
	}
}
