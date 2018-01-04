package com.sirketadi.forum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminIncludeController {
	
	//menu
	
		@RequestMapping(value="/adminnavbar")
		public String menu() {
			return "/admin/inc/adminnavbar";
		}
		
		@RequestMapping(value="/scriptlink")
		public String scriptlink() {
			return "/admin/inc/scriptlink";
		}
		
	

}
