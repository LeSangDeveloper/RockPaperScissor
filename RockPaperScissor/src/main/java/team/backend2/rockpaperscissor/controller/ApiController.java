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

@RestController
@RequestMapping("/api")
public class ApiController {
	
	HashMap<String, String> Rooms = new HashMap<String, String>();
	
	@RequestMapping(value ="/test" ,method = RequestMethod.GET)
    public String test(HttpServletRequest request,Model model) {
        	return "test";
        	
    }
	
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String find(HttpServletRequest request)
    {
    	
    	Cookie player = WebUtils.getCookie(request, "playerId");
    	
    	// Nếu khoong có phòng nào
    	if (Rooms.isEmpty())
    	{
    		Rooms.put(player.getValue(), "inactive");
    		return null;
    	}
    	else
    	{
    		// Duyệt từng phòng
    		for (String roomId : Rooms.keySet())
    		{
    			// Nếu phòng chưa chơi
    			if (Rooms.get(roomId) == "inactive")
    			{
    				Rooms.replace(roomId, "active");
    				return roomId;
    			}
    		}
    		Rooms.put(player.getValue(), "inactive");
    	}
    	return null;
    }
    
    @RequestMapping(value = "/match", method = RequestMethod.POST)
    public String match(HttpServletRequest request)
    {
    	
    	return null;
    }

}