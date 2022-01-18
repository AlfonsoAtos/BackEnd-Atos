package com.backend.webproject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.models.AdminData;
import com.backend.models.UserData;

@RestController
public class LoginCRUD {
	static DatabaseConnection db = new DatabaseConnection();
	
	@PostMapping("/api/login_admin")
	public AdminData loginAdmin(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		AdminData admin = db.getAdmin(email);
		if (admin != null && admin.getPassword().equals(pass)) {
//			model.addAttribute("admin_name", admin.getName());
//			model.addAttribute("admin_email", admin.getEmail());
			admin.setPassword(null);
		}
		return admin;
	}
	
	@PostMapping("/api/signup")
	public UserData signup(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String name = req.getParameter("name");
		String number = req.getParameter("number");
		System.out.println("signup");
//		if db.registerUser(email, pass, name, number);
		
		return new UserData();
	}
	
//	@RequestMapping("calculate")
//	public String calc(HttpServletRequest request, Model model)
//	{
//		int first = Integer.parseInt(request.getParameter("fno"));
//		int second = Integer.parseInt(request.getParameter("sno"));
//		
//		int ans = first + second;
//		
//		model.addAttribute("x", first);
//		model.addAttribute("y", second);
//		model.addAttribute("z", ans);
//		
//		//System.out.println(first + "  " + second + "  " + ans);
//		
//		return "answer";//view name---answer.jsp
//	}
}
