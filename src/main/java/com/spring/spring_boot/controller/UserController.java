package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String printUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/new")
    public String getUserForm(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @GetMapping(value = "/show")
    public String getById(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "show";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String updateUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PatchMapping(value = "/")
    public String editUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
