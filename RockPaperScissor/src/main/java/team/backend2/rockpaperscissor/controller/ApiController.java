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
    public String GetFind(HttpServletRequest request)
    {
    	
    	Cookie player = WebUtils.getCookie(request, "playerId");
    	
    	// Nếu khoong có phòng nào
    	if (Rooms.isEmpty())
    	{
    		Rooms.put(player.getValue(), "inactive");
    		return "new";
    	}
    	else
    	{
    		// Duyệt từng phòng
    		for (String roomId : Rooms.keySet())
    		{
    			// Nếu phòng chưa chơi
    			if (Rooms.get(roomId) == "inactive" && roomId != player.getValue())
    			{
    				Rooms.replace(roomId, "active");
    				return roomId;
    			}
    		}
    		Rooms.put(player.getValue(), "inactive");
    	}
    	return "new";
    }
    
    // Trong lúc chủ phòng chờ sẽ liên tục gọi api này
    @RequestMapping(value = "/waiting", method = RequestMethod.GET)
    public String GetWaiting(HttpServletRequest request)
    {
    	
    	Cookie player = WebUtils.getCookie(request, "playerId");
    	// Nếu vẫn chưa có ng vô phòng trả về "none"
    	if(Rooms.get(player.getValue()) == "inactive")
    	{
    		return "none";
    	}
    	//Nếu đã có người vô phòng trả về match
    	return "matched";
    }
    
    // Hàm này sau khi chủ phòng đã có người vô phòng, và ng chơi khách vô phòng gọi
    @RequestMapping(value = "/match", method = RequestMethod.POST)
    public String GetMatch(HttpServletRequest request)
    {
    	
    	return null;
    }

}