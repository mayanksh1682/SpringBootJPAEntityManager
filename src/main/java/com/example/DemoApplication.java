package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.api.GenericDao;
import com.example.domain.User;


@SpringBootApplication
@RestController
public class DemoApplication {
	
	@Autowired  
    private GenericDao genericDao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	@RequestMapping("/save")
	List<User> save() {
		User user1 = new User("Mayank", 37);
		User user2 = new User("Parul", 36);
		Stream<User>  stream = Stream.of(user1,user2);
		List<User> userList = stream.collect(Collectors.toList());
		
		genericDao.persist(userList);
		
		System.out.println("User1 Identity "+user1.getId());
		System.out.println("User2 Identity "+user2.getId());
		
		return userList;
		
		
	}
	
	@RequestMapping("/fetch")
	List<User> fetch() {
		Map<String,Object> params = new HashMap<>();
		params.put("name", "Mayank");
		List<User> userList = genericDao.executeNamedQuery("User.findByUserName", params);		
		return userList;
		
		
	}
}
