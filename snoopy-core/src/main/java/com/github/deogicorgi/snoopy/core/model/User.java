package com.github.deogicorgi.snoopy.core.model;

import com.github.deogicorgi.snoopy.core.orm.entity.UserEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class User {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String description;

    private UserStatus userStatus;

    private Role role;

    public User() {
    }

    private User(User.UserBuilder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.description = builder.description;
        this.userStatus = builder.userStatus;
        this.role = builder.role;
    }

    public static class UserBuilder implements Builder<User> {
        private final Long id;
        private final String username;
        private final String password;
        private final String email;
        private final String description;
        private final UserStatus userStatus;
        private final Role role;

        public UserBuilder(UserEntity userEntity) {
            this.id = userEntity.getId();
            this.username = userEntity.getUsername();
            this.password = userEntity.getPassword();
            this.email = userEntity.getEmail();
            this.description = userEntity.getDescription();
            this.userStatus = new UserStatus.UserStatusBuilder(userEntity.getUserStatus()).build();
            this.role = new Role.RoleBuilder(userEntity.getRole()).build();
        }

        @Override
        public User build() {
            return new User(this);
        }
    }

}
