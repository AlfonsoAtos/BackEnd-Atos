package com.backend.webproject.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.webproject.dao.UserDAO;
import com.backend.webproject.entity.User;

@Component
public class UserManager {
  @Autowired
  UserDAO db;

  public User signupUser(String email, String pass, String name, String number) {
    if (db.registerUser(email, pass, name, number) == 1) {
			// Create shopping cart
			return db.getUser(email);
		}
    return null;
  }

  public User loginUser(String email, String pass) {
    User userResult = db.getUser(email);
		if (userResult != null && userResult.getPassword() != null && userResult.getPassword().equals(pass)) {
			return userResult;
		}
		return null;
  }
}
