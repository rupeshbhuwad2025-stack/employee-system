package com.lms.handler;

import com.lms.dto.UserDto;
import com.lms.entity.UserEntity;

public class UserEntityHandler {
	
	public static UserDto mapToUserDto(UserEntity entity, UserDto userDto) {
		userDto.setId(entity.getId());
		userDto.setUserName(entity.getUserName());
		userDto.setPassword(entity.getPassword());
		userDto.setFirstName(entity.getFirstName());
		userDto.setLastName(entity.getLastName());
		userDto.setEmailId(entity.getEmailId());
		userDto.setContact(entity.getContact());
		userDto.setActive(entity.isActive());
		return userDto;
	}
	
	public static UserEntity mapToUserEntity(UserDto userDto, UserEntity entity) {
		entity.setUserName(userDto.getUserName());
		entity.setPassword(userDto.getPassword());
		entity.setFirstName(userDto.getFirstName());
		entity.setLastName(userDto.getLastName());
		entity.setEmailId(userDto.getEmailId());
		entity.setContact(userDto.getContact());
		entity.setActive(userDto.isActive());
		return entity;
	}

}
