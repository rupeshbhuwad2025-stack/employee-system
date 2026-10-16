package com.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.dto.UserDto;
import com.lms.entity.UserEntity;
import com.lms.handler.UserEntityHandler;
import com.lms.repository.UserRepository;

@Service
public class UserService {
	
	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDto addUser(UserDto userDto) {
		UserEntity entity = UserEntityHandler.mapToUserEntity(userDto, new UserEntity());
		entity = userRepository.save(entity);		
		userDto.setId(entity.getId());
		return userDto;
	}
	
	public UserDto updateUser(UserDto userDto) {
		UserEntity entity = userRepository.findById(userDto.getId()).orElseThrow(() -> new RuntimeException("User not found"));
		UserEntityHandler.mapToUserEntity(userDto, entity);
		userRepository.save(entity);	
		return userDto;
	}
	
	public UserDto getUserById(long id) {
		UserEntity entity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		return UserEntityHandler.mapToUserDto(entity, new UserDto());
	}
	
	public Boolean deleteUser(long id) {
		try {
			userRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}		
	}
	
	public List<UserDto> getAllUsers() {
		List<UserEntity> entities = userRepository.findAll();
		List<UserDto> userDtos = new ArrayList<>();
		for (UserEntity entity : entities) {
			userDtos.add(UserEntityHandler.mapToUserDto(entity, new UserDto()));
		}
		return userDtos;
	}

}
