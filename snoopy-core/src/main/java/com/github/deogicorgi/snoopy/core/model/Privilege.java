package com.github.deogicorgi.snoopy.core.model;

import com.github.deogicorgi.snoopy.core.orm.entity.PrivilegeEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Privilege {

    private Long id;

    private String name;

    private String description;

    public Privilege() {
    }

    private Privilege(Privilege.PrivilegeBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }

    public static class PrivilegeBuilder implements Builder<Privilege> {
        private final Long id;
        private final String name;
        private final String description;

        public PrivilegeBuilder(PrivilegeEntity privilegeEntity) {
            this.id = privilegeEntity.getId();
            this.name = privilegeEntity.getName();
            this.description = privilegeEntity.getDescription();
        }

        @Override
        public Privilege build() {
            return new Privilege(this);
        }
    }
}
