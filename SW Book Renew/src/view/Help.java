package view;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Help extends JFrame{
	
	public Help(){
		
		JPanel mainPanel = new JPanel(new GridLayout(5,1));
		
		JTextArea text1 = new JTextArea("�������� ���α׷� �Դϴ�.");
		mainPanel.add(text1);
		
		JTextArea text2 = new JTextArea("�� ���α׷��� ������� ������Ȳ�� �����ִ� ���α׷� �Դϴ�. ������ �� ��쿡 ����� ������ Ȯ���� �ּ���.");
		mainPanel.add(text2);
		
		JTextArea text3 = new JTextArea("��Ÿ ���ǻ����̳� ���� �߽߰� ������ �����ּ���.");
		mainPanel.add(text3);

		JTextArea text4 = new JTextArea("caucse@cau.ac.kr");
		mainPanel.add(text4);
		
		JTextArea text5 = new JTextArea("Alphabook ver 1.2");
		mainPanel.add(text5);
		
	}
}
