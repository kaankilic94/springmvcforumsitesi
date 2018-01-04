package com.sirketadi.forum;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileUploadController{
	
	@RequestMapping(value = "/file/{id}", method = RequestMethod.GET)
	public String resimekle(Model model, @PathVariable String id) {
		model.addAttribute("id", id);
		return "file";
	}

}