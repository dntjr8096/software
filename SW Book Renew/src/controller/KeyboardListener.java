package controller;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.LoginFrame;
import view.makeFirstFrame;
import model.User;
import model.database;

public class KeyboardListener implements KeyListener {
	private JTextField IDField;
	private JTextField PWField;
	private LoginFrame login;
	private database db;
	private User user = new User();

	public KeyboardListener(JTextField IDField, JTextField PWField, LoginFrame login, database db) {
		this.IDField = IDField;
		this.PWField = PWField;
		this.login = login;
		this.db = db;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		if (e.getKeyCode() == 10) {
			if (db.checkLogin(IDField.getText(), PWField.getText())) {
				
				this.user.inputID(IDField.getText());
				this.user.inputPW(PWField.getText());
				//this.user.inputBooks(db.getReadingList(IDField.getText()));
				
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
		    	    
			} else {
				login.setMode(2);
				JOptionPane.showMessageDialog(null, "ID나 비밀번호를 잘못 입력하였습니다.");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	
	
}