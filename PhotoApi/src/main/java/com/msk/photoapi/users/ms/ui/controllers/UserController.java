package com.msk.photoapi.users.ms.ui.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msk.photoapi.users.ms.ui.model.CreateUserReqModel;
import com.msk.photoapi.users.ms.ui.model.CreateUserResModel;
import com.msk.photoapi.users.ms.ui.model.shared.UserDto;
import com.msk.photoapi.users.ms.ui.service.UsersServiceI;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UsersServiceI usersServiceI;
	

	
	@GetMapping("/status/check")
	public String Status() {
		return "working";
		
	}
	
	@PostMapping()
	public ResponseEntity<CreateUserResModel> createUser(@Valid @RequestBody CreateUserReqModel createUserRequest) {
		ModelMapper mapper= new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto udto=mapper.map(createUserRequest, UserDto.class);
		UserDto createduser=usersServiceI.createUser(udto);
		CreateUserResModel returnValue=mapper.map(createduser, CreateUserResModel.class);
		return  ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
		
	}
}
