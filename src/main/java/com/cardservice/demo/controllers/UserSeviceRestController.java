package com.cardservice.demo.controllers;


import com.cardservice.demo.models.User;
import com.cardservice.demo.services.UserOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserSeviceRestController {

    @Autowired
    private UserOperationService userOperationService;


    @RequestMapping("/add")
    public Boolean addUser(@RequestBody User user){
        userOperationService.add(user);
        return true;
    }

    @RequestMapping("/delete")
    public Boolean deleteUser(@RequestBody User user){
        User temp = userOperationService.findUserByPhone(user.getPhoneNumber());
        userOperationService.delete(temp);
        return true;
    }

}
