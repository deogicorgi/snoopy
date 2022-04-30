package com.github.deogicorgi.snoopy.core.orm.entity;

import com.github.deogicorgi.snoopy.core.model.Builder;
import com.github.deogicorgi.snoopy.core.model.User;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;

@Getter
@Entity(name = "user")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId")
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
            this.userStatus = ObjectUtils.isEmpty(user.getUserStatus()) ? null : new UserStatusEntity.UserStatusEntityBuilder(user.getUserStatus()).build();
            this.role = ObjectUtils.isEmpty(user.getRole()) ? null : new RoleEntity.RoleEntityBuilder(user.getRole()).build();
        }

        @Override
        public UserEntity build() {
            return new UserEntity(this);
        }
    }

}
