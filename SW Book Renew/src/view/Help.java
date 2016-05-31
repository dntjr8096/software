package view;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Help extends JFrame{
	
	public Help(){
		
		 this.setTitle("Help");
	     this.setSize(400, 400);
	     this.setLocationRelativeTo(null);
	     this.setVisible(true);
		
		
		JPanel mainPanel = new JPanel(new GridLayout(5,1));
		
		JTextArea text1 = new JTextArea("도서관리 프로그램 입니다.");
		mainPanel.add(text1);
		
		JTextArea text2 = new JTextArea("이 프로그램은 사용자의 독서현황을 보여주는 프로그램 입니다." + "\n" + "사용법을 모를 경우에 사용자 문서를 확인해 주세요.");
		mainPanel.add(text2);
		
		JTextArea text3 = new JTextArea("기타 문의사항이나 버그 발견시 메일을 보내주세요.");
		mainPanel.add(text3);

		JTextArea text4 = new JTextArea("wwwghost6@naver.com");
		mainPanel.add(text4);
		
		JTextArea text5 = new JTextArea("Alphabook ver 3.2");
		mainPanel.add(text5);
		
		this.add(mainPanel);
	}
}
