package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.clearBtnEventHandler;
import model.database;

public class Setting extends JFrame{
	
	JButton clearBtn;
	database db;
	JTextField IDField;
	JTextField PWField;
	
	public Setting(database db){
		
		this.db = db;
		
		 this.setTitle("Setting");
	     this.setSize(500, 200);
	     this.setLocationRelativeTo(null);
	     this.setVisible(true);
	
		JPanel mainPanel = new JPanel(new GridLayout(2,1));
		JPanel topPanel = new JPanel(new FlowLayout());
		
		IDField = new JTextField(15);
	    PWField = new JTextField(10);
	    topPanel.add(new JLabel("ID"));
	    topPanel.add(IDField);
	    topPanel.add(new JLabel("PW"));
	    topPanel.add(PWField);
		clearBtn = new JButton("초기화");
		topPanel.add(clearBtn);
		
		mainPanel.add(topPanel);
		mainPanel.add(new JTextField("본인의 ID와 PW를 입력후에 초기화 버튼을 누르세요" + "\n" + "버튼을 누르면 바로 초기화가 실행되니 주의 하시기 바랍니다."));
		
		clearBtn.addActionListener(new clearBtnEventHandler(IDField,PWField,db));
		
		this.add(mainPanel);
	}
}
