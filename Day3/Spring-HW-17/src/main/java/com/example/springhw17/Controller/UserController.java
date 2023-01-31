package com.example.springhw17.Controller;

import com.example.springhw17.Exception.ApiException;
import com.example.springhw17.Model.User;
import com.example.springhw17.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User>users=userService.getUser();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid@RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid@RequestBody User user,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate=userService.updateUser(id,user);
        if(isUpdate) {
            return ResponseEntity.status(200).body("User Updated");
        }
        //return ResponseEntity.status(400).body("Wrong Id");
        throw new ApiException("Wrong Id");
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteUser(@PathVariable Integer id){
        boolean isDelete=userService.deleteUser(id);
        if(isDelete) {
            return ResponseEntity.status(200).body("User Deleted");
        }
        throw new ApiException("wrong Id");
                //ResponseEntity.status(400).body("Wrong Id");


    }
    @GetMapping("/username/{username}")
    public ResponseEntity findUsername(@PathVariable String username){
        User user=userService.findByUsername(username);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("byusernameandpassword/{username}/{password}")
    public ResponseEntity getByUsernameAndPassword(@PathVariable String username,@PathVariable String password){
        User user=userService.findByUsernameAndPassword(username,password);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/byemail/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
        User user=userService.findByEmail(email);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/byrole/{role}")
    public ResponseEntity getByRole(@PathVariable String role){
        List<User> user=userService.findAllByRole(role);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/byage/{age}")
    public ResponseEntity getByAge(@PathVariable Integer age){
        List<User>users=userService.findByAge(age);
        return ResponseEntity.status(200).body(users);
    }
}
