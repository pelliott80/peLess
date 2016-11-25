package com.blackpatchpanel.free.peless.controller;

import java.io.File;
import java.io.IOException;

import com.blackpatchpanel.free.peless.model.Model;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

public class TabController {

	// this is the Tab that is hooked up to the Tab Pane
	@FXML 
	Tab tabController = new Tab();
	
	// The TextArea that displays the text
	@FXML
	private TextArea textArea = new TextArea();
	
	// reference back to the Base Controller
	Base baseOfTab;

	// the model for this program
	Model model;
	
	// portability when separating lines.
	String separator;

	public TabController() {
		super();
		
		// thing to put in between lines.
		separator = System.getProperty("line.separator");
	}

	public void loadText(File file) {
		
		
		try {
			for (String line : model.getFileContentList(file)) {
				
				// append the line to the buffer.
				textArea.appendText( line + separator );
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
