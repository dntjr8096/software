package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import model.database;
import view.Help;

public class helpEventHandler implements ActionListener{

	Help helpFarme;
	database db;
	User user;
	
	public helpEventHandler(database db, User user){
		this.db = db;
		this.user = user;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		helpFarme = new Help(db,user);
		
	    db.conUserDB(user.getID(), user.getBooks());
	}

	
}
