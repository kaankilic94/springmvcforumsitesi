package com.sirketadi.forum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IncludeController {
	
	//menu
	
		@RequestMapping(value="/navbar")
		public String menu() {
			return "inc/navbar";
		}
		
		@RequestMapping(value="/footer")
		public String footer() {
			return "inc/footer";
		}
		
		@RequestMapping(value="/sidebar")
		public String sidebar() {
			return "inc/sidebar";
		}

}
