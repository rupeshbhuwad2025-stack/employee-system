package com.lms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dto.UserDto;
import com.lms.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<UserDto>> getUserList(){
		return userService.getAllUsers().isEmpty()?new ResponseEntity<List<UserDto>>(HttpStatus.NO_CONTENT):
			new ResponseEntity<List<UserDto>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable long id){
		UserDto userDto = userService.getUserById(id);
		return userDto==null?new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT):
			new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
	}
	
	/*@PostMapping("/users/authenticate")
	public User authenticateUser(@RequestBody User user){
		List<User> list = DBUtil.generateUserList();
		List<User> filter = list.stream().filter(u->u.getUsername().equals(user.getUsername())
				&& u.getPassword().equals(user.getPassword())).collect(Collectors.toList());
		return filter==null?null:filter.get(0);
	}*/
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
		userDto.setActive(true);
		userDto.setCreatedAt(System.currentTimeMillis());
		return new ResponseEntity<UserDto>(userService.addUser(userDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable long id){		;
		return new ResponseEntity<Boolean>(userService.deleteUser(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody UserDto userDto){
		userDto.setId(id);		
		return new ResponseEntity<UserDto>(userService.updateUser(userDto),HttpStatus.OK);
	}
}
