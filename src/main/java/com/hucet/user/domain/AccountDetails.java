package com.hucet.user.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class AccountDetails {

    private boolean isEnabled = true;

    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsNonExpired = true;
}
