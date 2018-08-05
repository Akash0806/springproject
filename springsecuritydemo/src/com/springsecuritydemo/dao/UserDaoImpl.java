package com.springsecuritydemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.springsecuritydemo.model.User;

@Component
public class UserDaoImpl implements UserDao{
	
	@PersistenceContext
	EntityManager entityManagerFactoryBean;
	
    
	public User getUser(String login) {
        List<User> userList = new ArrayList<User>();
        Query query = entityManagerFactoryBean.createQuery("from User u where u.username = :login");
        query.setParameter("login", login);
        userList = query.getResultList();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;    
    }
	
	@Override
	public Long save(User user){
		entityManagerFactoryBean.persist(user);
		return user.getId();
		
	}

}
