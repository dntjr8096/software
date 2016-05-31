package view;

import java.awt.Component;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

import model.Book;

//JList에 한 칸을 Cell이라 하는데 그 Cell의 양식을 정하는 class List.setCellRender에서 사용
public class BookRenderer extends DefaultListCellRenderer{
	 public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {
	        JLabel renderer = (JLabel)(super.getListCellRendererComponent(list, value, index, isSelected, hasFocus));
	        if (value instanceof Book) {
	            Book b = (Book)value;
	            renderer.setText("제목: " + b.Title + "    저자: " + b.Author);
	            ImageIcon temp;
				try {
					temp = new ImageIcon(new URL(b.Cover));
					Image tempi = temp.getImage();		//ImageIcon을 Image로 변환
					Image transi = tempi.getScaledInstance(250, 240, Image.SCALE_SMOOTH);
					ImageIcon icon = new ImageIcon(transi);		//Image로 ImageIcon 생성
					renderer.setIcon(icon);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	//temp를 resize할것임
	            }
	        return renderer;
	 }
}
