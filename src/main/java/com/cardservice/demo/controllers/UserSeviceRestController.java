package com.cardservice.demo.controllers;


import com.cardservice.demo.models.User;
import com.cardservice.demo.services.UserOperationService;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserSeviceRestController {

    @Autowired
    private UserOperationService userOperationService;


    @RequestMapping("/add")
    public Boolean addUser(User user){
        return userOperationService.add(user);
    }

    @RequestMapping("/delete")
    public Boolean deleteUser(User user){
        userOperationService.delete(user);
        return true;
    }

}
