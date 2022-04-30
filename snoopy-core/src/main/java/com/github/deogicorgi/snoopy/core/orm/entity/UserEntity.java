package com.github.deogicorgi.snoopy.core.orm.entity;

import com.github.deogicorgi.snoopy.core.model.Builder;
import com.github.deogicorgi.snoopy.core.model.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "user")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    private String username;

    @Column(length = 100)
    private String password;

    @Column(unique = true, length = 100)
    private String email;

    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    private RoleEntity role;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "userId")
    private UserStatusEntity userStatus;

    private UserEntity(UserEntity.UserEntityBuilder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.description = builder.description;
        this.userStatus = builder.userStatus;
        this.role = builder.role;
    }

    public static class UserEntityBuilder implements Builder<UserEntity> {
        private final Long id;
        private final String username;
        private final String password;
        private final String email;
        private final String description;
        private final UserStatusEntity userStatus;
        private final RoleEntity role;

        public UserEntityBuilder(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.email = user.getEmail();
            this.description = user.getDescription();
            this.userStatus = new UserStatusEntity.UserStatusEntityBuilder(user.getUserStatus()).build();
            this.role = new RoleEntity.RoleEntityBuilder(user.getRole()).build();
        }

        @Override
        public UserEntity build() {
            return new UserEntity(this);
        }
    }

}
