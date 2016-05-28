import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.ID_PW_CODE;

public class LoginEventHandler implements ActionListener {
	private JTextField IDField, PWField;
	private LoginFrame login = null;
	
	public LoginEventHandler(JTextField IDField, JTextField PWField, LoginFrame login) {
		this.IDField = IDField;
		this.PWField = PWField;
		this.login = login;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String ID = IDField.getText(); // ID 받아오기
		String PW = PWField.getText(); // PW 받아오기
		String event = e.getActionCommand();		
		if (event.equals("OK") && ID.equals(ID_PW_CODE.ADMIN_ID) && PW.equals(ID_PW_CODE.ADMIN_PW)) {
			login.setMode(1);
			login.setVisible(false);
			login.turnOff();

			JOptionPane.showMessageDialog(null, "안녕하세요 Master");
		}
		else if (event.equals("OK") && !(ID.equals(ID_PW_CODE.ADMIN_ID) && PW.equals(ID_PW_CODE.ADMIN_PW))) {
			login.setMode(2);
			//login.turnOff();
			JOptionPane.showMessageDialog(null, "ID나 비밀번호를 잘못 입력하였습니다.");
		}
	}	
	
}
