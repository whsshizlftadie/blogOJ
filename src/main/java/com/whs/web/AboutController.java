package com.whs.web;


import com.whs.bean.User;
import com.whs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/about")
public class AboutController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String about(Model model, HttpSession session){
        User user=new User();
        if(session.getAttribute("user") == null){
            user=userService.findWhs(100L);
        }else{
            user=userService.findById(((User)session.getAttribute("user")).getId());
        }

        model.addAttribute("about", user);
        return "about";
    }

}
