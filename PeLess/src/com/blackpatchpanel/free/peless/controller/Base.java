package com.blackpatchpanel.free.peless.controller;

import javafx.scene.layout.VBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * 
 * @author Paul Elliott <pelliott@blackpatchpanel.com>
 * This is the controller for the base of the scene.
 * it contains the MenuBar and the Tabbed Pane
 * the Tabs are dynamic and are constructed separately
 * 
 * This class works hand and glove with base.fxml
 * they should be considered together
 */
public class Base {
	/*
	 * Automatically generated constructor for base
	 */
    public Base() {
		super();
	}

    /*
     * This is comming from the top of base.fxml
     */
	@FXML
    private VBox container;
	
	/*
	 * called from base.fxml to exit the program.
	 */
	/**
	 * 
	 * @param event the action event from the 
	 * Exit menu item requesting exit from the program
	 */
	@FXML
	void requestExit(ActionEvent event) {
	    Platform.exit();
	}
	
}
