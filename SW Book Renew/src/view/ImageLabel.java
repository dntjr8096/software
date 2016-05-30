package view;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageLabel extends JLabel{

	private ImageIcon icon;
	
	public ImageLabel(){
		setSize(150, 180);
		//addMouseListener(l);
	}
	
	public void mySetIcon(String url){
		try {
			//resize 작업, 그림을 Label 크기에 맞게 설정
			ImageIcon temp = new ImageIcon(new URL(url));	//temp를 resize할것임
			Image tempi = temp.getImage();		//ImageIcon을 Image로 변환
			Image transi = tempi.getScaledInstance(150, 180, Image.SCALE_SMOOTH);
			icon = new ImageIcon(transi);		//Image로 ImageIcon 생성
			setIcon(icon);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
