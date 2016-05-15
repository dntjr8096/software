import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
   private JTextField IDField, PWField;
   private JButton OKBtn;
   public int mode;
   
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
      
      setLoginFrame();
      OKBtn.addActionListener(new LoginEventHandler(IDField, PWField, this));
      
      IDField.addKeyListener(new KeyboardListener(IDField, PWField, this));
      PWField.addKeyListener(new KeyboardListener(IDField, PWField, this));
      this.setVisible(true);
   }
   public void setLoginFrame() {   
      this.setLayout(new FlowLayout());
      this.add(new JLabel("ID"));
      this.add(IDField);
      this.add(new JLabel("PW"));
      this.add(PWField);
      this.add(OKBtn);
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