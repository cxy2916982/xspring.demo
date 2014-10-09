package com.sgl.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sgl.model.User;
import com.sgl.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/reg")
	public String register(){
		return "index";
	}
	@RequestMapping("/user")
	public ModelAndView addUser(String username,String password) {
		
		ModelAndView mav=null;
		User user = new User() ;
		user.setUsername(username) ;
		user.setPassword(password) ;
		user.setId(UUID.randomUUID().toString());
		user.setRegtime(new Date());
		try {
			userService.addUser(user);
		//	request.setAttribute("user", user);
			mav = new ModelAndView();
			mav.setViewName("success");
			mav.addObject("user", user);
			mav.addObject("msg", "注册成功了，可以去登陆了");
			System.out.println("xxxxxxxxxxx");
			System.out.println("zzzzzzzzzzz");
			return mav;
		} catch (Exception e) {
			mav.setViewName("error");
			mav.addObject("user", null);
			mav.addObject("msg", "注册失败");
			return mav;
		}
	}

}
