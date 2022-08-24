package com.api.rest.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	//public final String UPLOAD_DIR = "C:\\Users\\saurabhmaurya\\Documents\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\bootrestbook\\src\\main\\resources\\static\\image";
	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
		
	}
	public boolean uploadFile(MultipartFile f) {
		boolean ok = false;
		try {

//						Method 1
//			InputStream is = f.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//
//			// write here;
//			FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + "\\" + f.getOriginalFilename());
//			fileOutputStream.write(data);
//			fileOutputStream.flush();
//			fileOutputStream.close();
//			ok= true;

			// Method 2;
			Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + f.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			ok = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;

	}
}
