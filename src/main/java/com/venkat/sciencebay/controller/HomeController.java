package com.venkat.sciencebay.controller;

import com.venkat.sciencebay.model.User;
import com.venkat.sciencebay.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public ModelAndView home(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@PostMapping("/loggedIn")
	public ModelAndView loggedIn(@RequestParam(name = "userName", defaultValue = "trader")String userName,
								 @RequestParam(name = "pWord", defaultValue = "trader") String pWord) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name",userName);
		modelAndView.setViewName("loggedin");
		return modelAndView;
	}
	
	@PostMapping("/html/signedIn") 
	public ModelAndView signedIn(@RequestParam(name = "firstName", defaultValue = "trader")String firstName,
								 @RequestParam(name = "lastName", defaultValue = "trader")String lastName,
								 @RequestParam(name = "userName", defaultValue = "trader")String userName,
								 @RequestParam(name = "pword", defaultValue = "trader")String pWord,
								 @RequestParam(name = "email", defaultValue = "trader@sciencebay.com")String email,
								 @RequestParam(name = "gender", defaultValue = "trader")String gender) {
		userRepository.save(new User(firstName,lastName,userName,pWord,email,gender));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userName", userName);
		modelAndView.setViewName("signedin");
		return modelAndView;
	}
	
	@GetMapping("/display")
	public Iterable<User> display() {
		return userRepository.findAll();
	}
	
}
