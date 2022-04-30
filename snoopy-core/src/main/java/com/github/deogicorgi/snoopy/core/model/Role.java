package com.github.deogicorgi.snoopy.core.model;

import com.github.deogicorgi.snoopy.core.orm.entity.RoleEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Role {

    private Long id;

    protected String name;

    protected String description;

    protected Boolean isEnabled;

    private Set<Privilege> privileges;

    public Role() {
    }

    private Role(Role.RoleBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.isEnabled = builder.isEnabled;
        this.privileges = builder.privileges;
    }

    public static class RoleBuilder implements Builder<Role> {
        private final Long id;
        private final String name;
        private final String description;
        private final Boolean isEnabled;
        private final Set<Privilege> privileges;

        public RoleBuilder(RoleEntity roleEntity) {
            this.id = roleEntity.getId();
            this.name = roleEntity.getName();
            this.description = roleEntity.getDescription();
            this.isEnabled = roleEntity.getIsEnabled();
            this.privileges = roleEntity.getPrivileges()
                    .stream()
                    .map(privilegeEntity -> new Privilege.PrivilegeBuilder(privilegeEntity).build())
                    .collect(Collectors.toSet());
        }

        @Override
        public Role build() {
            return new Role(this);
        }
    }
}
