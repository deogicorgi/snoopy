package com.github.deogicorgi.snoopy.core.orm.repository;

import com.github.deogicorgi.snoopy.core.orm.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
