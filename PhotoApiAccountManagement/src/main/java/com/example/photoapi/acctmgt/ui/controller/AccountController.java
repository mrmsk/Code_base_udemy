package com.example.photoapi.acctmgt.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AccountController {
	
	@GetMapping("/status/check")
	public String status() {
		return "working fine";
	}
}
