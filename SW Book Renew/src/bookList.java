

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class bookList extends JFrame{
	
	
	private JTable userTable = new JTable();
	private JScrollPane listJs = new JScrollPane(userTable);
	private JPanel listPanel = new JPanel(new BorderLayout());
	 
	private makeTable courseListTable = new makeTable(userTable, listJs, listPanel);
	
	public bookList(info datas){

		add(new JTextField("읽고싶은 책을 골라 주세요.(상세정보 띄우는 창은 DB연동 후에 구축함)"), BorderLayout.NORTH);
		
		fileControl list = new fileControl("bookList.txt",courseListTable);
		list.read();
		add(listPanel, BorderLayout.CENTER);
		
		userTable.addMouseListener(new ClickListenerClass(datas));
	  }
	
	
	private class ClickListenerClass extends MouseAdapter {
		
		info datas;
		int row;
		JTable table;
		
		ClickListenerClass(info datas){
			this.datas = datas;
		}
		
		@Override
		public void mouseClicked(MouseEvent e3) {
			table = (JTable)e3.getSource();
			row = table.getSelectedRow();
			
			String[] value = new String[4];
			
			for(int i = 0; i<4 ; i++){
				value[i] = (String)(userTable.getValueAt(row, i));
			}
			
			datas.setText(value);
			
		}
			
	}
}
