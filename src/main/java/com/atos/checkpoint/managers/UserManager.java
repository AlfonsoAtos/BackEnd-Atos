package com.atos.checkpoint.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atos.checkpoint.dao.UserDAO;
import com.atos.checkpoint.entity.User;

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
	  if (email != null && pass != null) {
		  User userResult = db.getUser(email);
		  if (userResult != null && pass.equals(userResult.getPassword())) {
			  return userResult;
		  }
	  }
	  return null;
  }
}
