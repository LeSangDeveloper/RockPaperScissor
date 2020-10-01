package team.backend2.rockpaperscissor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import team.backend2.rockpaperscissor.handler.GamePool;
import team.backend2.rockpaperscissor.model.Game;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GamePlayController {
//	@RequestMapping(value = "/test/turn", method = RequestMethod.POST)
//	public String test(@RequestParam(value = "uid") String uid, @RequestParam(value = "roomid") String roomid)
//	{
//
//		return roomid + " " + uid;
//	}
////  @RequestMapping(method = RequestMethod.POST)
    @PostMapping("/turn")
        public String handle(HttpServletRequest request) {
            Cookie uid = WebUtils.getCookie(request, "playerId");
            Cookie game_id = WebUtils.getCookie(request, "gameId");
            //String player = request.getParameter("uid");
            //String room_id = request.getParameter("room_id");
            Integer choose = Integer.parseInt(request.getParameter("choose"));
            if (uid == null)
                return "signup";

            GamePool gamePool = GamePool.getInstance();
            Game curGame = gamePool.findById(game_id.toString());

            if(curGame == null) return "You are not in any game";

            curGame.update(uid.toString(), choose);
            if(curGame.isfinish())
                if(curGame.getWinner().equals(uid.toString()))
                    return "You Win";
                else return "You Lose";
            return "Waiting";
        }
    }
