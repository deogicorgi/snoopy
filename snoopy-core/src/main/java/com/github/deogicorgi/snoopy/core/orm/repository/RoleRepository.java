package com.github.deogicorgi.snoopy.core.orm.repository;

import com.github.deogicorgi.snoopy.core.orm.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
