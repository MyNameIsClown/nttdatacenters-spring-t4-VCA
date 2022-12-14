package com.nttdata.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador principal
 * 
 * @author Victor Carrasco
 *
 */
@Controller
@RequestMapping("/*")
public class HomeController {
	@RequestMapping("home")
	public String home() {
		return "index";
	}
}
