package com.helg893.pp_3_1_2_spring_boot_crud.controllers;

import com.helg893.pp_3_1_2_spring_boot_crud.models.User;
import com.helg893.pp_3_1_2_spring_boot_crud.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;


@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/users";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping(value = "/users")
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }

        userService.save(user);
        return "redirect:/users";
    }

    private static final String ERROR_MSG_USER_ID_NOT_FOUND = "Пользователь c id=%s не найден";

    @GetMapping(value = "/users/edit")
    public String edit(@RequestParam String id, Model model) {
        try {
            model.addAttribute("user", userService.findById(Long.parseLong(id)).orElseThrow());
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(ERROR_MSG_USER_ID_NOT_FOUND, id));
        }
        return "users/edit";
    }

    @PatchMapping(value = "/users")
    public String update(@RequestParam String id,
                         @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }

        try {
            userService.update(Long.parseLong(id), user);
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(ERROR_MSG_USER_ID_NOT_FOUND, id));
        }
        return "redirect:/users";
    }

    @DeleteMapping(value = "/users")
    public String delete(@RequestParam String id) {
        try {
            userService.delete(Long.parseLong(id));
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(ERROR_MSG_USER_ID_NOT_FOUND, id));
        }
        return "redirect:/users";
    }

}
