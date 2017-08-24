package com.tae.deadpool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeadpoolController {
	
	@GetMapping("/test")
	public String index() {
		return "home.jsp";
	}
}
