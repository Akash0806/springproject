package com.springsecuritydemo.dao;

import com.springsecuritydemo.model.User;

public interface UserDao {
	User getUser(String login);

	Long save(User user);

}
