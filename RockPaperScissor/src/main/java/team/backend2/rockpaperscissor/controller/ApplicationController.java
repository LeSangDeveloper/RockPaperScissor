package team.backend2.rockpaperscissor.controller;

import java.util.ArrayList;
import java.lang.System;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ApplicationController {
	
	ArrayList<String> Players;
	
    @RequestMapping(method = RequestMethod.GET)
    public String hello(@CookieValue("player") String player,Model model) {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        
        if (player == null)
        	return "signup";
        else
        	return "index";
    }
    
    @RequestMapping(value = "/signup"  ,method = RequestMethod.GET)
    public String GetSignUp()
    {
    	return "signup";
    }
    
    @RequestMapping(value = "/signup"  ,method = RequestMethod.POST)
    public String PostSignUp(String userName, HttpServletResponse response)
    {
    	System.out.print("test");
    	response.addCookie(new Cookie("player", userName));
    	return "index";
    }
    
}
