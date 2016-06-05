package Test;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.*;

import model.Book;
import model.XMLReader;
import view.BookPanel;

public class PanelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame m = new MyFrame();
	}
	
	static class MyFrame extends JFrame{
		
		public MyFrame(){
			setSize(1000, 500);
			setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			XMLReader xmlr = XMLReader.newInstance();
			ArrayList<Book> books = xmlr.getParseResult("소프트웨어공학", "Title");
			ArrayList<BookPanel> bps = new ArrayList<BookPanel>();
			for(Book b : books){
				BookPanel bp = new BookPanel();
				bp.setContent(b);
				bps.add(bp);
			}
			
			DefaultListModel model = new DefaultListModel();
			
			for(BookPanel bp : bps){
				model.addElement(bp);
			}
			
			JList list = new JList(model);
			list.setFixedCellWidth(40);
			list.setSelectedIndex(-1);
			
			list.setCellRenderer(new PanelRenderer());
			JScrollPane scroll = new JScrollPane(list);
			final JScrollBar scrollBar = scroll.getVerticalScrollBar();
		        scrollBar.addAdjustmentListener(new AdjustmentListener() {
		            public void adjustmentValueChanged(AdjustmentEvent e) {
		                System.out.println("JScrollBar's current value = " + scrollBar.getValue());
		            }
		        });
		       
		    this.getContentPane().add(scroll);
		    setVisible(true);
		    
		}
	}
	
	static class PanelRenderer implements ListCellRenderer {

	    @Override
	    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	        BookPanel renderer = (BookPanel) value;
	        renderer.setBackground(isSelected ? new Color(0,0,255,30) : Color.WHITE);
	        renderer.getAuthor().setBackground(isSelected ? new Color(0,0,255,30) : Color.WHITE);
	        renderer.getAuthor().setOpaque(true);
	        renderer.getTitle().setBackground(isSelected ? new Color(0,0,255,30) : Color.WHITE);
	        renderer.getTitle().setOpaque(true);
	        return renderer;
	    }
	}
}
