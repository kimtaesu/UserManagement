package com.hucet.user.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
