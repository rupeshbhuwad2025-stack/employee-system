package com.lms.util;



import java.util.ArrayList;
import java.util.List;

import com.lms.entity.Employee;
import com.lms.entity.User;


public class DBUtil {
	public static List<Employee> generateEmployeeList(){
		List<Employee> list = new ArrayList<Employee>();
		for(int i=0; i<100; i++){
			Employee emp = new Employee("Employee_Name_"+i, (i%3), "Department_"+(i%3), ((i%5)*20000), "Designation_"+(i%7));
			list.add(emp);
		}
		return list;
	}
	
	public static List<User> generateUserList(){
		List<User> list = new ArrayList<User>();
		list.add(getUser(12, "rupesh", "Rupesh", "Bhuwad", "rupesh@123", "$%$#@#$#"));
		list.add(getUser(12, "rugved", "Rugved", "Bhuwad", "rugved@123", "$%$#@#$#"));
		list.add(getUser(12, "daksh", "Daksh", "Bhuwad", "daksh@123", "$%$#@#$#"));
		list.add(getUser(12, "ruhi", "Ruhi", "Bhuwad", "ruhi@123", "$%$#@#$#"));
		list.add(getUser(12, "siddhi", "Siddhi", "Bhuwad", "siddhi@123", "$%$#@#$#"));
		list.add(getUser(12, "riddhi", "Riddhi", "Bhuwad", "riddhi@123", "$%$#@#$#"));
		return list;
	}
	
	public static User getUser(long id, String username, String firstName, String lastName, String password, String token) {
		User user  = new User();
		user.setId(id);
		user.setUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setToken(token);
		return user;
	}
}
