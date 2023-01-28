package com.whs.web.admin;

import com.whs.bean.User;
import com.whs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("login")
    public String login(@RequestParam String username, HttpServletRequest request, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes){

        String vrifyCode = (String) request.getSession().getAttribute("vrifyCode");
        request.getSession().removeAttribute("vrifyCode");
        String kaptcha = request.getParameter("kaptcha");
        if(!(kaptcha.equals(vrifyCode)&&kaptcha!=null&&!kaptcha.equals(""))){
            redirectAttributes.addFlashAttribute("message","验证码错误");
            return "redirect:/admin";
        }


        User check = userService.check(username, password);
        if(check!=null){
            check.setPassword(null);
            session.setAttribute("user",check);
            return "admin/index";
        }
        else{
            redirectAttributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("logout")
    public String Logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
