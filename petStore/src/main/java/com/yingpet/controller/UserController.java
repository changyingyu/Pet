package com.yingpet.controller;

/**
 * Created by yingyuchang on 2017-01-18.
 */
import com.yingpet.model.UserEntity;
import com.yingpet.service.SecurityService;
import com.yingpet.service.UserService;
import com.yingpet.validator.UserValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private UserService userService;

    private SecurityService securityService;

    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public String registration(Model model) {
       // model.addAttribute("userForm", new UserEntity());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserEntity userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> login(Model model, String error, String logout) {
        if (error != null)
            return ResponseEntity.ok("{'status' : 'ok'}");

        if (logout != null)
            return ResponseEntity.badRequest().body("Bad Request");

        return ResponseEntity.badRequest().body("Bad Request");


    }

}