package com.backend.webproject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

import com.backend.models.AdminData;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CRUDRouter {
	
	static DatabaseConnection db = new DatabaseConnection();

	@RequestMapping(value = "/adminlist", method = RequestMethod.GET)
	public List<AdminData> getAdmins() {
		return db.getAllEmployees();
	}
}
