import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginFrame loginmanager = new LoginFrame("Alphabook Login");
	      loginmanager.setVisible(true);
	      
	      while (true) {
		         if (!loginmanager.isVisible()){
		        	 
		        	 break;
		         }
		            
		      }
	      
	      
	      if (loginmanager.getMode() == 1) {
	    	  makeBookList frame = new makeBookList();
	    	    frame.setTitle("MakeCourseSchedule");
	    	    frame.setSize(1000, 600);
	    	    frame.setLocationRelativeTo(null);
	    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	    frame.setVisible(true);
	       }
	       else if (loginmanager.getMode() == 2) {
	          System.exit(0);
	       }
	      
	      
	}

}
