package view;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.KeyboardListener;
import controller.LoginEventHandler;
import controller.registerEventHandler;
import model.database;

public class LoginFrame extends JFrame {
   private JTextField IDField, PWField;
   private JButton OKBtn, registerBtn;
   public int mode;

	private database db = new database();
   
   public LoginFrame() {
      this("Master");
   }
   public LoginFrame(String title) {   
      this.setTitle(title);
      this.setSize(500, 300);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      IDField = new JTextField(15);
      PWField = new JTextField(10);
      OKBtn = new JButton("OK");
      registerBtn = new JButton("회원가입");
      
      db.checkDB();
      
      setLoginFrame();
      OKBtn.addActionListener(new LoginEventHandler(IDField, PWField, this, db));
      registerBtn.addActionListener(new registerEventHandler(IDField, PWField, db));
      IDField.addKeyListener(new KeyboardListener(IDField, PWField, this, db));
      PWField.addKeyListener(new KeyboardListener(IDField, PWField, this, db));
      this.setVisible(true);
      
   }
   public void setLoginFrame() {   
      this.setLayout(new GridLayout(2,1));
      JPanel Insertpanel = new JPanel(new FlowLayout());
      Insertpanel.add(new JLabel("ID"));
      Insertpanel.add(IDField);
      Insertpanel.add(new JLabel("PW"));
      Insertpanel.add(PWField);
      Insertpanel.add(OKBtn);
      Insertpanel.add(registerBtn);
      this.add(Insertpanel);
      this.add(new JTextField("ID와 PW칸에 입력후 회원가입 버튼을 누르면 회원등록이 됩니다."));
   }
   public void turnOn() {   
      this.setVisible(true);
   }
   public void turnOff() {
      this.setVisible(false);
   }
   public void setMode(int m) {
      this.mode = m;
   }
   public int getMode() {
      return this.mode;
   }
}