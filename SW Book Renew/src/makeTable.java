

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class makeTable {

	private JTable userTable;
	private JScrollPane listJs;
	private JPanel listPanel;
	 
	private Vector<String> userColumn = new Vector<String>();
	private DefaultTableModel model = new DefaultTableModel();
	 
	makeTable(JTable userTable, JScrollPane listJs, JPanel listPanel){
	this.userTable = userTable;
	this.listJs = listJs;
	this.listPanel = listPanel;
		
	userColumn.addElement("책제목");
	userColumn.addElement("저자");
	userColumn.addElement("읽기 시작한 날짜");
	userColumn.addElement("읽은 페이지");
	
	model.setColumnIdentifiers(userColumn);
	userTable.setModel(model);
	
	listPanel.add(listJs);
	
	}
	
	void addRow(String a, String b, String c, String d){
		Vector<String> addString = new Vector<String>();
		addString.addElement(a);
		addString.addElement(b);
		addString.addElement(c);
		addString.addElement(d);
		
		model.addRow(addString);
		
	}
	
	void initialize(){
		model.setNumRows(0);
	}
	
	int getRowCount(){
		return model.getRowCount();
	}
	
	Object getValueAt(int i, int j){
		return model.getValueAt(i, j);
	}
}
