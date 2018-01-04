package com.sirketadi.forum;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ResimController {

	@RequestMapping(value = "/resim", method = RequestMethod.GET)
	public String resim(Model model,  HttpServletRequest req) {
		
		return "resim";
	}
	
	@RequestMapping(value = "/resim", method = RequestMethod.POST)
	public String resimpost(@RequestParam("file") File file, Model model,  HttpServletRequest req) {
		
		file.getAbsolutePath();
		
		return "resim";
	}
	
}
