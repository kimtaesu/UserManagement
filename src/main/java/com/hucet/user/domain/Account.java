package com.hucet.user.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Account {
    @Id
    @Getter
    @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    private Long id;

    private String userName;
    @Getter
    @Column(unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    @Embedded
    private AccountDetails accountDetails;
    @ManyToMany
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();
}
