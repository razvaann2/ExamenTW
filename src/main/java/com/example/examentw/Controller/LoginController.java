package com.example.examentw.Controller;

import com.example.examentw.Entity.UserEntity;
import com.example.examentw.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index(){
        return "login";}

    private final UserService userService;
@PostMapping("/login")
    private String login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Model model, HttpSession session){
    UserEntity user = userService.getUserByUsernameAndPassword(username, password);
    if (user != null) {
        // Autentificare reușită
        session.setAttribute("username", user.getUsername());
        return "redirect:/dashboard";
        //return "redirect:/dashboard?loggedInUser="+user.getUsername(); // Redirectează către pagina de bord sau altă pagină protejată
    } else {
        // Autentificare eșuată
        model.addAttribute("error", "Invalid username or password");
        System.out.println("Logare nereusita: 0");
        return "redirect:/login"; // Redirecționează înapoi către pagina de login cu un mesaj de eroare
    }

}
}
