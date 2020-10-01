package team.backend2.rockpaperscissor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import team.backend2.rockpaperscissor.handler.GamePool;
import team.backend2.rockpaperscissor.model.Game;
import team.backend2.rockpaperscissor.model.GameTurn;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GamePlayController {
	@RequestMapping(value = "/test/turn", method = RequestMethod.POST)
	public String test(@RequestParam(value = "uid") String uid, @RequestParam(value = "roomid") String roomid)
	{
		
		return roomid + " " + uid;
	}
//  @RequestMapping(method = RequestMethod.POST)
    @PostMapping("/turn")
        public String handle(HttpServletRequest request) {
            //Cookie player = WebUtils.getCookie(request, "player");
            //Cookie room_id = WebUtils.getCookie(request, "room_id");
            String player = request.getParameter("uid");
            String room_id = request.getParameter("room_id");
            Integer choose = Integer.parseInt(request.getParameter("choose"));
            if (player == null)
                return "signup";

            GamePool gamePool = GamePool.getInstance();
            Game curGame = gamePool.findById(room_id.toString());

            if(curGame == null) return "You are not in any game";

            curGame.update(player.toString(), choose);
            if(curGame.isfinish())
                if(curGame.getWinner().equals(player.toString()))
                    return "You Win";
                else return "You Lose";
            return "Waiting";
        }
    }
