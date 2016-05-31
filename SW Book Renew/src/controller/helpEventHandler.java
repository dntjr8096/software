package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Help;

public class helpEventHandler implements ActionListener{

	Help helpFarme;
	
	public helpEventHandler(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		helpFarme = new Help();
	}

	
}
