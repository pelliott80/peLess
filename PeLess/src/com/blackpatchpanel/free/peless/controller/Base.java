package com.blackpatchpanel.free.peless.controller;

import javafx.scene.layout.VBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Base {
    public Base() {
		super();
	}

	@FXML
    private VBox container;
	
	@FXML
	void requestExit(ActionEvent event) {
	    Platform.exit();
	}
	
}
