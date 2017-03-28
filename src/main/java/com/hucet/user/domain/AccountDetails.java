package com.hucet.user.domain;

import javax.persistence.Embeddable;

@Embeddable
public class AccountDetails {

    private boolean isEnabled = true;

    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsNonExpired = true;
}
