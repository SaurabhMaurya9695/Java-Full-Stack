package com.api.rest.controller;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.rest.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getOriginalFilename());

		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Request must contain file");
			}
			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Only jpeg containt allows");
			}
			// file upload code;
			boolean ok = fileUploadHelper.uploadFile(file);
			if(ok == true) {
//				return ResponseEntity.ok("file is succesfully upoloaded");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("can't uploaded");
	}
}
