package com.example.examentw.Controller;

import com.example.examentw.Entity.UserEntity;
import com.example.examentw.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final UserService userService;

    public DashboardController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String showDashboardPage(Model model, HttpSession session) {
        Object usernameObj=session.getAttribute("username");
        if (usernameObj != null ) {
            String username = usernameObj.toString();
            UserEntity user= userService.getUserByUsername(username);
            model.addAttribute("username", username);
            model.addAttribute("role",user.getRole());
            return "dashboard";
        } else {
            // Tratează cazul în care nu este nimeni autentificat și redirecționează către pagina de login sau altă pagină relevantă
            return "redirect:/";
        }

    }
}
