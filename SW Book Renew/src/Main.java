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
	       }
	       else if (loginmanager.getMode() == 2) {
	          System.exit(0);
	       }
	      
	      
	}

}
