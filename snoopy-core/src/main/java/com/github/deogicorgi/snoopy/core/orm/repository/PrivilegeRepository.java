package com.github.deogicorgi.snoopy.core.orm.repository;

import com.github.deogicorgi.snoopy.core.orm.entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity, Long> {
}
