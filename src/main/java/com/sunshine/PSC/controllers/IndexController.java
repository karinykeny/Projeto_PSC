package com.sunshine.PSC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD:src/main/java/com/sunshine/PSC/controllers/IndexController.java
=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> master:src/main/java/com/sunshine/PSC/controllers/HomeController.java

@Controller
public class IndexController {
	
	@GetMapping("/")
<<<<<<< HEAD:src/main/java/com/sunshine/PSC/controllers/IndexController.java
	public String index() {
	
	       return "/index";
=======
	public String home() {
	
	       return "/home";
>>>>>>> master:src/main/java/com/sunshine/PSC/controllers/HomeController.java
		}
	
}

