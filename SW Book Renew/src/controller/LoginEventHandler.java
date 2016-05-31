package controller;
import java.awt.event.*;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.User;
import view.LoginFrame;
import view.makeFirstFrame;
import model.database;

public class LoginEventHandler implements ActionListener {
	private JTextField IDField, PWField;
	private LoginFrame login = null;
	database db;
	private User user = new User();
	
	public LoginEventHandler(JTextField IDField, JTextField PWField, LoginFrame login, database db) {
		this.IDField = IDField;
		this.PWField = PWField;
		this.login = login;
		this.db = db;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String ID = IDField.getText(); // ID 받아오기
		String PW = PWField.getText(); // PW 받아오기
		String event = e.getActionCommand();
		
		if (event.equals("OK") && db.checkLogin(ID, PW)) {

			this.user.inputID(IDField.getText());
			this.user.inputPW(PWField.getText());
			//this.user.inputBooks(db.getAllData(IDField.getText()));
			
			login.setMode(1);
			login.setVisible(false);	
			login.turnOff();

			JOptionPane.showMessageDialog(null, "안녕하세요 Master");

			
			makeFirstFrame frame = new makeFirstFrame(db,user);
	    	    frame.setTitle("MakeCourseSchedule");
	    	    frame.setSize(600, 500);
	    	    frame.setLocationRelativeTo(null);
	    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	    frame.setVisible(true);
	    	    
	    	    frame.getbookManageBtn().addMouseListener(new bookManageBtnEventHandler(user));
		}
		else if (event.equals("OK") && !(db.checkLogin(ID, PW))) {
			login.setMode(2);
			//login.turnOff();
			JOptionPane.showMessageDialog(null, "ID나 비밀번호를 잘못 입력하였습니다.");
		}
	}	
	
}
