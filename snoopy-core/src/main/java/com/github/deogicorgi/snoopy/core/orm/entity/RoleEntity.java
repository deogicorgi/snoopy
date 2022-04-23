package com.github.deogicorgi.snoopy.core.orm.entity;

import com.github.deogicorgi.snoopy.core.model.AbstractRole;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "role")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoleEntity extends AbstractRole {

    @OneToMany
    private Set<PrivilegeEntity> privileges;

}
