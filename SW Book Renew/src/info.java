

import javax.swing.JComboBox;
import javax.swing.JTextField;

class info {
	
	private JTextField bookName;
	private JTextField writer;
	private JTextField startTime;
	private JTextField ing;
	
	info(){
		bookName = new JTextField();
		writer = new JTextField();
		startTime = new JTextField();
		ing = new JTextField();
	}
	
	void setText(String[] value){
		bookName.setText(value[0]);
		writer.setText(value[1]);
		startTime.setText(value[2]);
		ing.setText(value[3]);
	}
	
	JTextField getbookName(){
		return bookName;
	}
	
	JTextField getwriter(){
		return writer;
	}
	
	JTextField getstartTime(){
		return startTime;
	}
	
	JTextField geting(){
		return ing;
	}
	
	String getbookNameString(){
		return bookName.getText();
	}
	
	String getwriterString(){
		return writer.getText();
	}

	String getstartTimeString(){
		return startTime.getText();
	}
	
	String getingString(){
		return ing.getText();
	}

}
