package controller;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;
import model.Book;

//ActionListener��� �������̽��� ��ӹ޴´�.
public class ActionFunc implements ActionListener{  
     
	private User user;
    
     
	@Override
	public void actionPerformed(ActionEvent e) {
          /*
           * �׼��� �Ͼ ��ü�� �޴����������� ��
           * �޴��������̸� �׼��� �Ͼ ��ü�� �޴������۰�ü�� ��ü����ȯ
           * command()�޼ҵ带 ȣ�� �޴������� ��ü�� ���� ������ ��ɾ�� �ν�
           */
          if (e.getSource() instanceof MenuItem){
           MenuItem m = (MenuItem)e.getSource();
           
          }
          else if(e.getSource().equals("�α���")){
        	  
          }
     }
 
}