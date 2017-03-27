package com.hucet.user.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by taesu on 2017-03-27.
 */
@Getter
@Entity
public class User {
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
