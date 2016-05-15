import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class KeyboardListener implements KeyListener {
	private JTextField IDField;
	private JTextField PWField;
	private LoginFrame login;

	KeyboardListener(JTextField IDField, JTextField PWField, LoginFrame login) {
		this.IDField = IDField;
		this.PWField = PWField;
		this.login = login;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		if (e.getKeyCode() == 10) {
			if (IDField.getText().equals("12")
					&& PWField.getText().equals("1")) {
				login.setMode(1);
				login.setVisible(false);
				login.turnOff();

				JOptionPane.showMessageDialog(null, "안녕하세요 Master");
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