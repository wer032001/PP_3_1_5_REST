package ru.kata.spring.boot_security.demo.conroller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
@RequiredArgsConstructor
//@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    private final UserService userService;

    //    public static String mail;
    @GetMapping
    public List<User> getUsers() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
       return userService.addUser(user);
    }

    @PutMapping
    public User editUser(@RequestBody User user) {
       return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
    }


//    @PostMapping
//    public User addUser(@RequestBody User user) {
//        return userService.addUser(user);
//    }


//    @GetMapping
//    public String getAllUsers(Model model) {
//        model.addAttribute("users", userService.listUsers());
////        model.addAttribute("useremail", userService.getUserByEmail(mail));
//        model.addAttribute("user", new User());
//        return "index";
//    }

//    @GetMapping("/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.removeUser(id);
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/getOne")
//    @ResponseBody
//    public User getOne(Long id) {
//        return userService.getUserById(id);
//    }

}
