package controller;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;
import model.Book;

//ActionListener라는 인터페이스를 상속받는다.
public class ActionFunc implements ActionListener{  
     
	private User user;
    
     
	@Override
	public void actionPerformed(ActionEvent e) {
          /*
           * 액션이 일어난 객체가 메뉴아이템인지 비교
           * 메뉴아이템이면 액션이 일어난 객체를 메뉴아이템객체로 객체형변환
           * command()메소드를 호출 메뉴아이템 객체의 라벨을 가져와 명령어로 인식
           */
          if (e.getSource() instanceof MenuItem){
           MenuItem m = (MenuItem)e.getSource();
           
          }
          else if(e.getSource().equals("로그인")){
        	  
          }
     }
 
}