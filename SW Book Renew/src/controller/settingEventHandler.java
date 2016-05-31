package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.database;
import view.Setting;

public class settingEventHandler implements ActionListener{

	Setting settingFarme;
	database db;
	
	public settingEventHandler(database db){
		this.db = db;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		settingFarme = new Setting(db);
	}

	
}
