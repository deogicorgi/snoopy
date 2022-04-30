package com.github.deogicorgi.snoopy.core.orm.entity;

import com.github.deogicorgi.snoopy.core.model.Builder;
import com.github.deogicorgi.snoopy.core.model.UserStatus;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity(name = "user_status")
@EqualsAndHashCode(of = "userId")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private Boolean isAccountLocked;

    private Boolean isAccountExpired;

    private Boolean isCredentialLocked;

    private Boolean isEnabled;

    private UserStatusEntity(UserStatusEntity.UserStatusEntityBuilder builder) {
        this.userId = builder.userId;
        this.isAccountLocked = builder.isAccountLocked;
        this.isAccountExpired = builder.isAccountExpired;
        this.isCredentialLocked = builder.isCredentialLocked;
        this.isEnabled = builder.isEnabled;
    }

    public static class UserStatusEntityBuilder implements Builder<UserStatusEntity> {
        private final Long userId;
        private final Boolean isAccountLocked;
        private final Boolean isAccountExpired;
        private final Boolean isCredentialLocked;
        private final Boolean isEnabled;

        public UserStatusEntityBuilder(UserStatus userStatus) {
            this.userId = userStatus.getUserId();
            this.isAccountLocked = userStatus.getIsAccountLocked();
            this.isAccountExpired = userStatus.getIsAccountExpired();
            this.isCredentialLocked = userStatus.getIsCredentialLocked();
            this.isEnabled = userStatus.getIsEnabled();
        }

        @Override
        public UserStatusEntity build() {
            return new UserStatusEntity(this);
        }
    }

}
