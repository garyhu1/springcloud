package com.garyhu.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public  String handlerFileUpload(@RequestParam(value="file",required=true) MultipartFile file)
	      throws IOException{
		byte[] bytes = file.getBytes();
		File fileToSave = new File(file.getOriginalFilename());
		FileCopyUtils.copy(bytes, fileToSave);
		return fileToSave.getAbsolutePath();
	}
	
	@RequestMapping(value="/fileUpload")
	public String fileUpload(){
		return "upload";
	}
	
	@RequestMapping(value="/")
	@ResponseBody
	public String index(){
		return "首页内容";
	}
}
