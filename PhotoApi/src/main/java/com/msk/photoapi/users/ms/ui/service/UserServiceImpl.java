package com.msk.photoapi.users.ms.ui.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.msk.photoapi.users.ms.database.UserEntity;
import com.msk.photoapi.users.ms.database.UsersRepository;
import com.msk.photoapi.users.ms.ui.model.shared.UserDto;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class UserServiceImpl implements UsersServiceI {
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserServiceImpl(UsersRepository usersRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usersRepository = usersRepository;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;

	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPwd(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = mapper.map(userDetails, UserEntity.class);
		usersRepository.save(userEntity);
		UserDto returnValue = mapper.map(userEntity, UserDto.class);
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity usrentity=usersRepository.findByEmail(username);
		if(usrentity==null) {
			throw new UsernameNotFoundException("User not found in Records"+username);
		}
		return new User(usrentity.getEmail(),usrentity.getEncryptedPwd(),true,true,true,true,new ArrayList<>());
	}

}
