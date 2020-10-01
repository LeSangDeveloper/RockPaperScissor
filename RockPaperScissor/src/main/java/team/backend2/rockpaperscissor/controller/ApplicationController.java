package team.backend2.rockpaperscissor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.System;

import javax.annotation.Nullable;
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
import org.springframework.web.util.WebUtils;
import java.util.UUID;
@Controller
@RequestMapping("/")
public class ApplicationController {
	
	@RequestMapping(method = RequestMethod.GET)
    public String hello(HttpServletRequest request,Model model) {
        
        Cookie player = WebUtils.getCookie(request, "playerId");
        
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
    public String PostSignUp(String name, HttpServletResponse response)
    {
    	UUID id = UUID.randomUUID();
    	response.addCookie(new Cookie("playerId", id.toString()));
    	response.addCookie(new Cookie("player", name));
    	return "index";
    }
    
}
