package com.example.springhw17.Service;

import com.example.springhw17.Model.User;
import com.example.springhw17.Repository.UserReopsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserReopsitory userReopsitory;

    public List<User> getUser(){
        return userReopsitory.findAll();
    }

    public void addUser(User user){
    userReopsitory.save(user);
    }

    public boolean updateUser(Integer id,User user){
        User oldUser=userReopsitory.findById(id).get();
        if(oldUser==null){
           return false;
        }
      oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());
        userReopsitory.save(oldUser);
        return true;
    }

    public boolean deleteUser(Integer id){
        User oldUser=userReopsitory.findById(id).get();
        if(oldUser==null){
            return false;
        }
        userReopsitory.delete(oldUser);
        return true;
    }
}
