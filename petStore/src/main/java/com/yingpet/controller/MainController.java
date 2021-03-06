package com.yingpet.controller;

import com.yingpet.model.UserEntity;
import com.yingpet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET,produces = "application/json")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET,produces = "application/json")
    public String getUsers(ModelMap modelMap) {

        return "admin/users";
    }


    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser() {
        return "admin/addUser";
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity) {

        userRepository.saveAndFlush(userEntity);

        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        UserEntity userEntity = userRepository.findOne(userId);

        modelMap.addAttribute("user", userEntity);
        return "admin/userDetail";
    }

    @RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        UserEntity userEntity = userRepository.findOne(userId);

        modelMap.addAttribute("user", userEntity);
        return "admin/updateUser";
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP") UserEntity user) {

        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId) {

        userRepository.delete(userId);

        userRepository.flush();
        return "redirect:/admin/users";
    }
}
