package com.example.springhw17.Repository;

import com.example.springhw17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReopsitory extends JpaRepository<User,Integer> {
}
