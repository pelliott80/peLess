package com.blackpatchpanel.free.peless.controller;

import javafx.scene.control.TabPane;
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
     * This is coming from the top of base.fxml
     * this is the object created in main
     */
	@FXML
    private VBox container;

	/*
     * This is coming from the bottom of base.fxml
     * this tab pane will have tabs added to it dynamically
     */
	@FXML	
	private TabPane tabPane;
	
	/*
	 * End user wants us to open a new file
	 * we must open it create a new tab for it
	 * and read the text into the text area
	 */
	@FXML
	void openNewFile(ActionEvent event) {

	}

	/*
	 * destroy the tab and return its resources.
	 * if after no tabs left then exit.
	 */
	@FXML
	void closeFile(ActionEvent event) {

	}
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
