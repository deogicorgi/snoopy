package com.github.deogicorgi.snoopy.core.orm.entity;

import com.github.deogicorgi.snoopy.core.model.AbstractPrivilege;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "privilege")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PrivilegeEntity extends AbstractPrivilege {


}
