package org.amadeus.charon.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

public class SyllabusUploader implements Receiver, SucceededListener {

	private File file;
	private static final String UPLOAD_PATH = "target/upload/";
	private String uploadedPath;
	
	@Override
	public void uploadSucceeded(SucceededEvent event) {
		event.getFilename();
		System.out.println(file.getAbsolutePath());
		System.out.println(event.getFilename());
		Path src = Paths.get(file.getAbsolutePath());
		Path dest = Paths.get(UPLOAD_PATH+file.getName());
		try {
			uploadedPath = dest.toString();
			Files.move(src, dest, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public OutputStream receiveUpload(String filename, String mimeType) {
		file = new File(filename);		
		try{
			if (mimeType.contains("pdf")) {
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				return fileOutputStream;
			}
			else {
				return null;
			}
		} catch(FileNotFoundException e){
			e.printStackTrace();
			return null;
		}
	}

	public String getUploadedPath() {
		return uploadedPath;
	}
	
	
	

}
