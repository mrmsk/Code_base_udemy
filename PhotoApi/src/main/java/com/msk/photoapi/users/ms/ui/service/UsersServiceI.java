package com.msk.photoapi.users.ms.ui.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.msk.photoapi.users.ms.ui.model.shared.UserDto;

public interface UsersServiceI extends UserDetailsService{
	
	UserDto createUser(UserDto UserDetails);

}
