package com.springmvc.services;

import com.springmvc.pojo.User;

public interface UserService {
	
    void save(User user);

    User findByUsername(String username);
}
