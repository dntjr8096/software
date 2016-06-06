package controller;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.LoginFrame;
import view.MyBookFrame;
import view.make;

import model.User;
import model.XMLReader;
import model.database;

public class KeyboardListener implements KeyListener {
	private JTextField IDField;
	private JTextField PWField;
	private LoginFrame login;
	private database db;
	private User user = new User();
	private XMLReader reader;

	public KeyboardListener(JTextField IDField, JTextField PWField, LoginFrame login, database db) {
		this.IDField = IDField;
		this.PWField = PWField;
		this.login = login;
		this.db = db;
		reader = XMLReader.newInstance();
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		if (e.getKeyCode() == 10) {
			if (db.checkLogin(IDField.getText(), PWField.getText())) {
				
				this.user.inputID(IDField.getText());
				this.user.inputPW(PWField.getText());
				//this.user.inputBooks(db.getAllData(IDField.getText()));
				
				login.setMode(1);
				login.setVisible(false);
				login.turnOff();

				JOptionPane.showMessageDialog(null, "�ȳ��ϼ��� Master");
				

					make frame = new make(db,user,reader);
		    	    frame.setTitle("MakebookSchedule");
		    	    frame.setSize(600, 500);
		    	    frame.setLocationRelativeTo(null);
		    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	    frame.setVisible(true);
		    	    
		    	    frame.getbookManageBtn().addMouseListener(new bookManageBtnEventHandler(user,reader));
		    	    frame.getHelpBtn().addActionListener(new helpEventHandler(db,user));
		    	    frame.getresetBtn().addActionListener(new settingEventHandler(db));
		    	    frame.getbookAddBtn().addMouseListener(new AddListListener(reader,user));
		    	    
			} else {
				login.setMode(2);
				JOptionPane.showMessageDialog(null, "ID�� ��й�ȣ�� �߸� �Է��Ͽ����ϴ�.");
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