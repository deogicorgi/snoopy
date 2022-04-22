package com.github.deogicorgi.snoopy.core.orm.repository;

import com.github.deogicorgi.snoopy.core.orm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
