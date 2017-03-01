package com.epam.test.web_app.controllers;

import com.epam.test.client.rest.api.UsersConsumer;
import com.epam.test.dao.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Users Controller.
 */
@Controller
public class UsersController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    UsersConsumer usersConsumer;

    @GetMapping(value = "/")
    public String defaultPageRedirect() {
        return "redirect:users";
    }

    @GetMapping(value = "/users")
    public String users(Model model) {
        LOGGER.debug(" /users page.");
        List usersList = usersConsumer.getAllUsers();
        model.addAttribute("usersList", usersList);
        return "users";
    }

    @GetMapping(value = "/user")
    public String editUser(@RequestParam("id") Integer id,
                           Model model) {
        LOGGER.debug("/user({})", id);
        User user = usersConsumer.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }
}