package com.spacenews.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UsersController {

        @Autowired
        private UsersService usersService;

        @GetMapping("/register")
        public String getRegisterPage(){
                return "register_page";
        }

        @PostMapping("/register")
        public String registerUser(@RequestParam String login, @RequestParam String password, @RequestParam String email, Model model) {
                UsersModel user = usersService.registerUser(login, password, email);
                if (user != null) {
                        model.addAttribute("message", "Registration successful");
                        return "login_page";
                } else {
                        model.addAttribute("error", "Registration failed");
                        return "register_page";
                }
        }

        @GetMapping("/login")
        public String getLoginPage(){
                return "login_page";
        }

        @PostMapping("/login")
        public String loginUser(@RequestParam String login, @RequestParam String password, Model model, HttpServletResponse response) {
                UsersModel user = usersService.authenticate(login, password);
                if (user != null) {
                        // Redirection vers localhost:8083/home
                        response.setHeader("Location", "http://localhost:8083/home");
                        response.setStatus(302);
                        return null;
                } else {
                        model.addAttribute("error", "Login failed");
                        return "login_page";
                }
        }
}
