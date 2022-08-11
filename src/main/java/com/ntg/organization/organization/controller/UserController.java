package com.ntg.organization.organization.controller;

import com.ntg.organization.organization.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntg.organization.organization.entity.User;
import com.ntg.organization.organization.service.UserService;

@RestController
@RequestMapping("/user/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/add")
	public UserDTO createNewUser(@RequestBody UserDTO user) {
		return userService.createNewUser(user);
	}

}
