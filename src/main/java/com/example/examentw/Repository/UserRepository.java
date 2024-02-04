package com.example.examentw.Repository;

import com.example.examentw.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findUserEntityByUsernameAndPassword(String username,String password);
    UserEntity findUserEntityByUsername(String username);
}
