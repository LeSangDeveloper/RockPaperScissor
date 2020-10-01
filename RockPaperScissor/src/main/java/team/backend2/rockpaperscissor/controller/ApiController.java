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
import team.backend2.rockpaperscissor.model.*;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	HashMap<String, String> Rooms = new HashMap<String, String>();
	
	@RequestMapping(value ="/test" ,method = RequestMethod.GET)
    public String test(HttpServletRequest request,Model model) {
        	return "test";
        	
    }
	
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String GetFind(HttpServletRequest request, HttpServletResponse response)
    {
    	String uid = WebUtils.getCookie(request, "playerId").getValue();
    	String result = WaitingPool.getInstance().findRoom(uid);
    	if (result.startsWith("-"))
    	{
    		response.addCookie(new Cookie("roomId", uid));
    		return "Play";
    	}
    	else if (result.equals(uid))
    	{
    		response.addCookie(new Cookie("roomId", uid));
    		return "Waiting";
    	}
    	else 
    	{
    		response.addCookie(new Cookie("roomId", result));
    		return result;
    	}
    }
    
    @RequestMapping(value = "/waiting", method = RequestMethod.GET)
    public String GetWaiting(HttpServletRequest request)
    {
    	String uid = WebUtils.getCookie(request, "playerId").getValue();
    	String result = WaitingPool.getInstance().findById(uid).getUid_2();
    	if (result == null)
    	{
    		return "Waiting";
    	}
    	else
    		return "Matched";
    }
    
    // Hàm này sau khi chủ phòng đã có người vô phòng, và ng chơi khách vô phòng gọi
    @RequestMapping(value = "/match", method = RequestMethod.POST)
    public String GetMatch(HttpServletRequest request, HttpServletResponse response)
    {
    	String roomId = WebUtils.getCookie(request, "playerId").getValue();
    	Room room = WaitingPool.getInstance().findById(roomId);
    	if (room.getGameId() == null)
    	{
    		room.setGameId(UUID.randomUUID().toString());
    	}
    	response.addCookie(new Cookie("gameId", room.getGameId()));
    	return room.getGameId();
    }

}