package com.github.deogicorgi.snoopy.core.orm.repository;

import com.github.deogicorgi.snoopy.core.orm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    @Query("select u from user u where u.username = ?1 or u.email = ?1")
    UserEntity findByUsernameOrEmail(String username);

    UserEntity findByUsernameAndPassword(String username, String password);
}
