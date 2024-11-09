package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Reposetory.userReposetory;
import com.example.demo.model.User;

@Controller
public class loginController {
	
	@Autowired
	private userReposetory userrepo;
	
	@GetMapping("/login")
	public String showForm() {
		return "login";
	}
	
	
	
	@PostMapping("/home")
	public String showHomepage(@ModelAttribute User user,Model model) {
		
		System.out.println(user.toString());
		
         model.addAttribute("name",user.getName());
         model.addAttribute("email",user.getEmail());
         model.addAttribute("password",user.getPassword());
         model.addAttribute("conform_password",user.getConform_password());
         
         
       User user_Inserted = userrepo.save(user);
       
       
         
		 return "home";
	}
	@GetMapping("/")
	public String ShowuserData(Model model) {
		model.addAttribute("LIstUser",userrepo.findAll());		
		return "ShowUser";				
	}
	@GetMapping("/show")
	public String SaveUser(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "ShowUser";
	}
	
	

}
