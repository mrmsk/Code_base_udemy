package com.msk.photoapi.users.ms.ui.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.photoapi.users.ms.database.UserEntity;
import com.msk.photoapi.users.ms.database.UsersRepository;
import com.msk.photoapi.users.ms.ui.model.shared.UserDto;

@Service
public class UserServiceImpl implements UsersServiceI {
	@Autowired
	UsersRepository usersRepository;

	public UserServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;

	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = mapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPwd("Tes1");
		usersRepository.save(userEntity);
		UserDto returnValue = mapper.map(userEntity, UserDto.class);
		return returnValue;
	}

}
