package com.blackpatchpanel.free.peless.controller;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.blackpatchpanel.free.peless.model.Model;

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
	
	private Model model;
	
	/*
	 * Automatically generated constructor for base
	 */
    public Base() {
		super();
		
		// the model for dealing with files.
		model = new Model();
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

		// create the file chooser
		FileChooser fileChooser = new FileChooser();
		// tell user why he is choosing a file
		fileChooser.setTitle("Open File for display");
		
		// run the dialog to get the files
		List<File> fileList = fileChooser.showOpenMultipleDialog( container.getScene().getWindow());
		
				
		for (File file : fileList) {
			System.out.println(file.toString());
			
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/tab.fxml"));
				
				Tab tabRoot = (Tab)fxmlLoader.load();

//				Tab tabRoot = FXMLLoader.load(getClass().getResource("/fxml/tab.fxml"));
				TabController mytabController = fxmlLoader.<TabController>getController();
				
				Tab controlersTab = mytabController.tabController;
				
				if (tabRoot != controlersTab) {
					System.out.println("not equal tabs");
					
				}
				
				// save reference to this Base in the tab's controller
				// so the tab controller can find the controller for its Base
				mytabController.baseOfTab = this;
				
				// save the model into the tab controller
				// the TabController needs access to the model
				mytabController.model = this.model;
				
				tabPane.getTabs().add(controlersTab);
//				controlersTab.setContent( (Node) FXMLLoader.load(getClass().getResource("fxml/tab.fxml")) );
				
				mytabController.loadText(file);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		}
	}

	/*
	 * destroy the tab and return its resources.
	 * if after no tabs left then exit.
	 */
	@FXML
	void closeFile(ActionEvent event) {
		Tab tab = tabPane.getSelectionModel().getSelectedItem();
		if (tab != null) {
			tab.getTabPane().getTabs().remove(tab);
//			Event.fireEvent(tab, new Event(Tab.CLOSED_EVENT));  // does not work
		}
//		tabPane.getTabs().remove();
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
