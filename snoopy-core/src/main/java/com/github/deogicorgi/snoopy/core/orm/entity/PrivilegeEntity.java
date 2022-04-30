package com.github.deogicorgi.snoopy.core.orm.entity;

import com.github.deogicorgi.snoopy.core.model.Builder;
import com.github.deogicorgi.snoopy.core.model.Privilege;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "privilege")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PrivilegeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "privilege_id")
    private Long id;

    @Column(unique = true, length = 50)
    private String name;

    @Column(length = 100)
    private String description;

    private PrivilegeEntity(PrivilegeEntity.PrivilegeEntityBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }

    public static class PrivilegeEntityBuilder implements Builder<PrivilegeEntity> {
        private final Long id;
        private final String name;
        private final String description;

        public PrivilegeEntityBuilder(Privilege privilege) {
            this.id = privilege.getId();
            this.name = privilege.getName();
            this.description = privilege.getDescription();
        }

        @Override
        public PrivilegeEntity build() {
            return new PrivilegeEntity(this);
        }
    }
}
