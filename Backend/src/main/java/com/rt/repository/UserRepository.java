package com.rt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rt.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

User findByEmail(String email);
List<User> findByRoleRoleName(String roleName);
User findByEmailAndPassword(String email, String password);



}
