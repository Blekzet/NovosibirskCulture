package com.culture_news.controller;

import com.culture_news.entity.User;
import com.culture_news.repositories.UserRepository;
import com.culture_news.service.NewsService;
import com.culture_news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NewsService newsService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "registration";
        }

        if (!user.getPassword().equals(user.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }

        if (!userService.saveUser(user)) {
            model.addAttribute("usernameError", true);
            return "registration";
        }


        return "redirect:/login";
    }
    @GetMapping("/admin")
    public String adminPage(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "admin";
    }

    @PostMapping("/admin/delete/{userId}")
    public String adminPage(Model model, @PathVariable Long userId){
        userService.deleteUser(userId);
        model.addAttribute("users", userRepository.findAll());
        return "admin";
    }
    @PostMapping("/admin/addrole/{userId}")
    public String adminSetUserRole(Model model, @PathVariable Long userId){
        userService.addRoleUser(userId);
        model.addAttribute("users", userRepository.findAll());
        return "admin";
    }

    @GetMapping("/user/selfProfile")
    public String selfProfilePage(Model model, Principal principal) {
        model.addAttribute("user", userRepository.findByUserName(principal.getName()));
        model.addAttribute("sidebarData", newsService.fourNewsList());
        return "selfProfile";
    }

    @GetMapping("/user/profile/{userName}")
    public String profilePage(Model model, @PathVariable String userName){
        model.addAttribute("user", userRepository.findByUserName(userName));
        model.addAttribute("sidebarData", newsService.fourNewsList());
        return "profile";
    }

    @GetMapping("/user/changeProfile")
    public String changeProfilePage(Model model, Principal principal) {
        model.addAttribute("user", userRepository.findByUserName(principal.getName()));
        return "changeProfile";
    }
    @PostMapping("/changeProfile")
    public String changeProfileSave(@ModelAttribute("user") User user, Model model, Principal principal){
        userService.changeUser(user, userRepository.findByUserName(principal.getName()));
        return "redirect:/user/selfProfile";
    }
    @GetMapping("/user/changeUserAvatar")
    public String changeAvatar(Model model, Principal principal) {
        model.addAttribute("user", userRepository.findByUserName(principal.getName()));
        return "changeUserAvatar";
    }
    @PostMapping("/changeUserAvatar")
    public String changeAvatarSave(@ModelAttribute("user") User user, Model model, Principal principal){
        userService.changeUserAvatar(user, userRepository.findByUserName(principal.getName()));
        return "redirect:/user/selfProfile";
    }

    @GetMapping("/user/changeUserName")
    public String changeUserName(Model model, Principal principal) {
        model.addAttribute("user", userRepository.findByUserName(principal.getName()));
        return "changeUserName";
    }
    @PostMapping("/changeUserName")
    public String changeUserNameSave(@ModelAttribute("user") User user, Model model, Principal principal){
        userService.changeUserName(user, userRepository.findByUserName(principal.getName()));
        return "redirect:/user/selfProfile";
    }

    @GetMapping("/user/changePassword")
    public String changePasswordPage(Model model, Principal principal){
        model.addAttribute("user", userRepository.findByUserName(principal.getName()));
        model.addAttribute("oldPassword", new String());
        return "changePassword";
    }
    @PostMapping("/changePassword")
    public String changePasswordSave(@ModelAttribute("user") User user, @ModelAttribute("oldPassword") String oldPassword, Model model, Principal principal){
        User oldUserData = userRepository.findByUserName(principal.getName());

        if (passwordEncoder.matches(user.getPassword(), oldUserData.getPassword())){
            model.addAttribute("matchError", "Новый пароль совпадает со старым");
            return "changePassword";
        }

        if (!passwordEncoder.matches(oldPassword, oldUserData.getPassword())){
            model.addAttribute("error", "Неправильно введен старый пароль");
            return "changePassword";
        }

        userService.changeUserPassword(user, oldUserData);
        return "redirect:/user/selfProfile";
    }

}
