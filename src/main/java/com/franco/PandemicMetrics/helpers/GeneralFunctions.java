package com.franco.PandemicMetrics.helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class GeneralFunctions {

	public static String saveImage(MultipartFile file, String routeImage) {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		fileName = fileName.replace(" ", "-");
		
		Integer count = 0;
		while(Files.exists(Paths.get(routeImage + (count == 0 ? "": count.toString() + "_") + fileName))) {
			count++;
		}
		
		String fileNameToSave = (count == 0 ? "": count.toString() + "_") + fileName;
		
		try {
		
			File imageFile = new File(routeImage + fileNameToSave);
			file.transferTo(imageFile);
			return fileNameToSave;
		
		}catch(IOException e) {
			
			System.out.println("Error " + e.getMessage());
			return null;
		}
		
		
	}
	
	public static Boolean deleteImage(String route,String fileName) {
		
		Path imagePath = Paths.get(route + fileName); 
		
		if(Files.exists(imagePath)) {
			
			try {
				Files.delete(imagePath);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return false;
	}
	
	
}
