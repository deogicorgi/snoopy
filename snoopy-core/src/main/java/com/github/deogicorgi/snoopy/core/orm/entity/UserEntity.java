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

    private Boolean isAccountLocked;

    private Boolean isAccountExpired;

    private Boolean isCredentialLocked;

    private Boolean isEnabled;

    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    private UserEntity(UserEntity.UserEntityBuilder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.isAccountLocked = builder.isAccountLocked;
        this.isAccountExpired = builder.isAccountExpired;
        this.isCredentialLocked = builder.isCredentialLocked;
        this.isEnabled = builder.isEnabled;
        this.description = builder.description;
        this.role = builder.role;
    }

    public static class UserEntityBuilder implements Builder<UserEntity> {
        private final Long id;
        private final String username;
        private final String password;
        private final String email;
        private final String description;
        private final Boolean isAccountLocked;
        private final Boolean isAccountExpired;
        private final Boolean isCredentialLocked;
        private final Boolean isEnabled;
        private final RoleEntity role;

        public UserEntityBuilder(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.email = user.getEmail();
            this.description = user.getDescription();
            this.isAccountLocked = user.getIsAccountLocked();
            this.isAccountExpired = user.getIsAccountExpired();
            this.isCredentialLocked = user.getIsCredentialLocked();
            this.isEnabled = user.getIsEnabled();
            this.role = ObjectUtils.isEmpty(user.getRole()) ? null : new RoleEntity.RoleEntityBuilder(user.getRole()).build();
        }

        @Override
        public UserEntity build() {
            return new UserEntity(this);
        }
    }

}
