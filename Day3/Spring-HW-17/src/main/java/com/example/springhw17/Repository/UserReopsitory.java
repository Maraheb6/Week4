package com.example.springhw17.Repository;

import com.example.springhw17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReopsitory extends JpaRepository<User,Integer> {

    User findUserById(Integer id);

    User findUserByUsername(String username);
    @Query("select  u from User u where u.id=?1")
    User findByMyId(Integer id);

    User findUserByUsernameAndPassword(String username,String password);

    User findUserByEmail(String email);

    List<User> findAllUserByRole(String role);

    List<User> findAllByAgeGreaterThanEqual(Integer age);

}
