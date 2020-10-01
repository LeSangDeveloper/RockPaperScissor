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
    		String room_id = result.substring(1,result.length());
    		Room room = WaitingPool.getInstance().findById(room_id);
    		if (room.getGameId() == null)
    		{
    			Game newGame = GamePool.getInstance().newGame(room_id, room.getUid_2());
    			room.setGameId(newGame.getId());
    		}
    		Cookie cookie = new Cookie("gameId", room.getGameId());
    		cookie.setPath("/");
    		response.addCookie(cookie);
    		return "Play";
    	}
    	else if (result.equals(uid))
    	{
    		return "Waiting";
    	}
    	else 
    	{
    		return result;
    	}
    }
}