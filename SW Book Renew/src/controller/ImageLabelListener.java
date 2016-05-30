package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;

import model.Book;
import view.ImageLabel;

public class ImageLabelListener implements MouseListener{

	private String link;
	
	public ImageLabelListener(String link){
		this.link = link;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount() == 2){	//더블클릭시
			openBrower(link);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    /**
     * 시스템에 있는 브라우저로 URL을 연다.
     * @param url
     */
    private void openBrower(String url)  {
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

        if( !desktop.isSupported( java.awt.Desktop.Action.BROWSE ) ) {
            System.err.println( "Desktop doesn't support web browser action" );
        }
        try {
            java.net.URI uri = new java.net.URI( url );
            desktop.browse( uri );
        }        
        catch (IOException _e) {
            System.err.println( _e.getMessage() );
        } 
        catch (URISyntaxException _e) {
            System.err.println( _e.getMessage() );
        }
    }




	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
