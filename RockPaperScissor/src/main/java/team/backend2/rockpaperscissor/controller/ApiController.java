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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;
import java.util.UUID;
import team.backend2.rockpaperscissor.handler.*;
@RestController
@RequestMapping("/api")
public class ApiController {
	
	HashMap<String, String> Rooms = new HashMap<String, String>();
	
	@RequestMapping(value ="/test" ,method = RequestMethod.GET)
    public String test(HttpServletRequest request,Model model) {
        	return "test";
        	
    }
	
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String GetFind(HttpServletRequest request)
    {
    	String uid = WebUtils.getCookie(request, "playerId").getValue();
    	String result = WaitingPool.getInstance().findRoom(uid);
    	if (result.startsWith("-"))
    	{
    		return "Play";
    	}
    	else if (result.equals(uid))
    	{
    		return "Waiting";
    	}
    	else return result;
    }
    
    @RequestMapping(value = "/waiting", method = RequestMethod.GET)
    public String GetWaiting(HttpServletRequest request)
    {

    	return null;
    }
    
    // Hàm này sau khi chủ phòng đã có người vô phòng, và ng chơi khách vô phòng gọi
    @RequestMapping(value = "/match", method = RequestMethod.POST)
    public String GetMatch(HttpServletRequest request)
    {
    	
    	return null;
    }

}