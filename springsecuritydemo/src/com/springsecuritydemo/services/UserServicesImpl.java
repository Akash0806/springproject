package com.springsecuritydemo.services;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springsecuritydemo.dao.UserDao;
import com.springsecuritydemo.model.Role;
import com.springsecuritydemo.model.User;

@Service
public class UserServicesImpl implements UserServices {
	@Autowired
	@Qualifier(value="userDaoImpl")
	UserDao daoImpl;
	
	@Resource(name="encoder")
	public BCryptPasswordEncoder passwordEncoder;
	    
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public long save(User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role=new Role();
		
		return daoImpl.save(user);
	}

}
