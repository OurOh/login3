package com.mycompany.myapp.controller;

import com.mycompany.myapp.model.User;
import com.mycompany.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.login(username, password);
        if (user != null) {
            model.addAttribute("user", user);
            return "home";  // �α��� ���� �� �̵��� ������
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // �α��� ���� �� �ٽ� �α��� ��������
        }
    }
}