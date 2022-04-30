package com.github.deogicorgi.snoopy.core.model;

import com.github.deogicorgi.snoopy.core.orm.entity.UserStatusEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "userId")
public class UserStatus {

    private Long statusId;

    private Boolean isAccountLocked = false;

    private Boolean isAccountExpired = false;

    private Boolean isCredentialLocked = false;

    private Boolean isEnabled = true;

    public UserStatus() {
    }

    private UserStatus(UserStatusBuilder builder) {
        this.statusId = builder.statusId;
        this.isAccountLocked = builder.isAccountLocked;
        this.isAccountExpired = builder.isAccountExpired;
        this.isCredentialLocked = builder.isCredentialLocked;
        this.isEnabled = builder.isEnabled;
    }

    public static class UserStatusBuilder implements Builder<UserStatus> {
        private final Long statusId;
        private final Boolean isAccountLocked;
        private final Boolean isAccountExpired;
        private final Boolean isCredentialLocked;
        private final Boolean isEnabled;

        public UserStatusBuilder(UserStatusEntity userStatusEntity) {
            this.statusId = userStatusEntity.getStatusId();
            this.isAccountLocked = userStatusEntity.getIsAccountLocked();
            this.isAccountExpired = userStatusEntity.getIsAccountExpired();
            this.isCredentialLocked = userStatusEntity.getIsCredentialLocked();
            this.isEnabled = userStatusEntity.getIsEnabled();
        }

        @Override
        public UserStatus build() {
            return new UserStatus(this);
        }
    }
}
