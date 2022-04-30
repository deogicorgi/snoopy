package com.github.deogicorgi.snoopy.core.orm.entity;

import com.github.deogicorgi.snoopy.core.model.Builder;
import com.github.deogicorgi.snoopy.core.model.Role;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Entity(name = "role")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    private String name;

    @Column(length = 100)
    private String description;

    private Boolean isEnabled = false;

    @OneToMany
    private Set<PrivilegeEntity> privileges;

    private RoleEntity(RoleEntity.RoleEntityBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.isEnabled = builder.isEnabled;
        this.privileges = builder.privileges;
    }

    public static class RoleEntityBuilder implements Builder<RoleEntity> {
        private final Long id;
        private final String name;
        private final String description;
        private final Boolean isEnabled;
        private final Set<PrivilegeEntity> privileges;

        public RoleEntityBuilder(Role role) {
            this.id = role.getId();
            this.name = role.getName();
            this.description = role.getDescription();
            this.isEnabled = role.getIsEnabled();
            this.privileges = role.getPrivileges()
                    .stream()
                    .map(privilege -> new PrivilegeEntity.PrivilegeEntityBuilder(privilege).build())
                    .collect(Collectors.toSet());
        }

        @Override
        public RoleEntity build() {
            return new RoleEntity(this);
        }
    }

}
