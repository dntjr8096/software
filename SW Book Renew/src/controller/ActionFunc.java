import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
//ActionListener��� �������̽��� ��ӹ޴´�.
public class ActionFunc implements ActionListener{ 
     HashMap<String, Object> actions = new HashMap<String, Object>();
 
     public ActionFunc(){
          // �޴��� ������ Ŭ������ ��������� ���⿡ �߰��Ѵ�.
//          actions.put("������", new NewFile());
//          actions.put("����", new OpenFile());
     }
 
     public void command(String command){
          /*
           * actions.get(command)�� object type�̴� 
           * �̰��� CommandProcess type���� ����� ����ȯ�� ��Ų��.
           * CommandProcess�� ������ �޼ҵ� �� doAction()�� ȣ���Ѵ�.
           */
          CommandProcess comm = (CommandProcess)actions.get(command);
          comm.doAction();
     }
    
     @Override
     public void actionPerformed(ActionEvent e) {
          /*
           * �׼��� �Ͼ ��ü�� �޴����������� ��
           * �޴��������̸� �׼��� �Ͼ ��ü�� �޴������۰�ü�� ��ü����ȯ
           * command()�޼ҵ带 ȣ�� �޴������� ��ü�� ���� ������ ��ɾ�� �ν�
           */
          if (e.getSource() instanceof MenuItem){
           MenuItem m = (MenuItem)e.getSource();
           command(m.getLabel());
          }
     }
 
}