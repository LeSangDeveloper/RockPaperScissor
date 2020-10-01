package team.backend2.rockpaperscissor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import team.backend2.rockpaperscissor.handler.GamePool;
import team.backend2.rockpaperscissor.model.Game;
import team.backend2.rockpaperscissor.model.Room;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GamePlayController {
@RequestMapping(value = "/turn", method = RequestMethod.GET)
        public String handle(HttpServletRequest request) {
            String uid = WebUtils.getCookie(request, "playerId").getValue();
            String game_id = WebUtils.getCookie(request, "gameId").getValue();
            Integer choose = Integer.parseInt(request.getParameter("choose"));
            if (uid == null)
                return "signup";

            GamePool gamePool = GamePool.getInstance();
            Game curGame = gamePool.findById(game_id);
            if(curGame == null) return "You are not in any game";

            curGame.update(uid, choose);
            if(curGame.isfinish()) {
                if (curGame.getWinner().equals(uid))
                    return "You Win";
                else return "You Lose";
            }
            return "Waiting";
        }
    }
