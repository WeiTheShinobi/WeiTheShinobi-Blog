package com.weitheshinobi.blog.controller.admin;

import com.weitheshinobi.blog.constant.UserConstant;
import com.weitheshinobi.blog.pojo.User;
import com.weitheshinobi.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

//    調用service
    @Autowired
    private UserService userService;

    @RequestMapping
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){

        User user = userService.checkUser(username, password);
        if(user != null){
            user.setPassword(null);
            session.setAttribute(UserConstant.USER,user);
            return "admin/index";
        } else {
            attributes.addFlashAttribute(UserConstant.MESSAGE, UserConstant.LOGIN_ERROR);
            return "redirect:/admin";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(UserConstant.USER);
        return "redirect:/admin";
    }

}
