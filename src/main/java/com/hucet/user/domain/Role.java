package com.hucet.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
@Getter
@Table(name = "ofRole")
@NoArgsConstructor
public class Role implements GrantedAuthority {

    public enum RoleType {
        ROLE_ADMIN, ROLE_USER
    }

    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    public Role(RoleType roleUser) {
        this.roleType = roleUser;
    }

    @Override
    public String getAuthority() {
        return roleType.name();
    }
}
