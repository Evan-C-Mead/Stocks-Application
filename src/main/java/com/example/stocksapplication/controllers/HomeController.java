package com.example.stocksapplication.controllers;

import com.example.stocksapplication.models.User;
import com.example.stocksapplication.repositories.UserRepository;
import com.example.stocksapplication.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final UserRepository userDao;
    private final PasswordEncoder encoder;
    private final UserService userService;

    public HomeController(UserRepository userDao, PasswordEncoder encoder, UserService userService) {
        this.userDao = userDao;
        this.encoder = encoder;
        this.userService = userService;
    }

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("title", "The Home Page");

        return "home";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("title", "Sign Up");
        model.addAttribute("user", new User());

        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String userSignUp(@ModelAttribute User user, Model model) {
        model.addAttribute("title", "Sign Up");
        String hashPW = encoder.encode(user.getPassword());
        user.setPassword(hashPW);
        userDao.save(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login Page");

        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("title", "User Dashboard");
        model.addAttribute("users", userDao.findByUsername(user.getUsername().toUpperCase()));

        return "dashboard";
    }

}
