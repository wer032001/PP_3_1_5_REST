package ru.kata.spring.boot_security.demo.conroller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    private final UserService userService;

    public static String mail;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("useremail", userService.getUserByEmail(mail));
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/getOne")
    @ResponseBody
    public User getOne(Long id) {
        return userService.getUserById(id);
    }
}

