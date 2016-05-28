import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
//ActionListener라는 인터페이스를 상속받는다.
public class ActionFunc implements ActionListener{ 
     HashMap<String, Object> actions = new HashMap<String, Object>();
 
     public ActionFunc(){
          // 메뉴별 각각의 클래스가 만들어지면 여기에 추가한다.
//          actions.put("새파일", new NewFile());
//          actions.put("열기", new OpenFile());
     }
 
     public void command(String command){
          /*
           * actions.get(command)는 object type이다 
           * 이것을 CommandProcess type으로 명시적 형변환을 시킨다.
           * CommandProcess의 유일의 메소드 인 doAction()을 호출한다.
           */
          CommandProcess comm = (CommandProcess)actions.get(command);
          comm.doAction();
     }
    
     @Override
     public void actionPerformed(ActionEvent e) {
          /*
           * 액션이 일어난 객체가 메뉴아이템인지 비교
           * 메뉴아이템이면 액션이 일어난 객체를 메뉴아이템객체로 객체형변환
           * command()메소드를 호출 메뉴아이템 객체의 라벨을 가져와 명령어로 인식
           */
          if (e.getSource() instanceof MenuItem){
           MenuItem m = (MenuItem)e.getSource();
           command(m.getLabel());
          }
     }
 
}