package com.blackpatchpanel.free.peless.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Model {

	public Model() {
		// TODO Auto-generated constructor stub
	}
	
	public List<String>  getFileContentList(File file) throws IOException {

		// turn file into a path with File.toPath
		// use path to return a list of lines. from the file.
		return Files.readAllLines(file.toPath());
	}

}
