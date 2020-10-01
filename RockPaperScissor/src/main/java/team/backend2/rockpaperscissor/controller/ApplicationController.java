package team.backend2.rockpaperscissor.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ApplicationController {
	
	ArrayList<String> Players;
	
    @RequestMapping(method = RequestMethod.GET)
    public String hello(Model model) {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        
        return "signup";
    }
    
    @RequestMapping(value = "/signup"  ,method = RequestMethod.GET)
    public String GetSignUp()
    {
    	return "signup";
    }
    
    @RequestMapping(value = "/signup"  ,method = RequestMethod.POST)
    public String PostSignUp()
    {
    	return "index";
    }
    
}
