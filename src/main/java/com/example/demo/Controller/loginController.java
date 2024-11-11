package com.example.demo.Controller;

import com.example.demo.Reposetory.userReposetory;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class loginController {

    @Autowired
    private userReposetory userrepo;

   
    @GetMapping("/login")
    public String showUserData() {
    	return "login";
    	
    }
    
    @GetMapping("/home")
    public String home(){
    	return "home";
    }
    
    @PostMapping("/home")
    public String Showhome(@ModelAttribute User user, Model model) {
    	userrepo.save(user); // Save user to database
    	return "home";
    }

    @PostMapping("/userdetails")
    public String submitForm(@ModelAttribute User user, Model model){
    	userrepo.save(user);
        model.addAttribute("listuser", userrepo.findAll()); // Fetch all users for display
        return "userdetails";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        User user = userrepo.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "update_user"; // Ensure this name matches the actual file name for the update form
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
    	userrepo.deleteById(id); // Delete the user from the database
        model.addAttribute("listuser", userrepo.findAll()); // Refresh list after deletion
        return "userdetails"; // Redirect to "welcome" page with updated list
    }

    @GetMapping("/userdetails")
    public String viewAllUsers(Model model) {
        model.addAttribute("listuser", userrepo.findAll()); // Fetch all users for display
        return "userdetails";
    }
}