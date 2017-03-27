package com.hucet.user.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@ToString
@Data
public class AccountDto implements Serializable {
    private Long id = null;
    @NotEmpty
    private String password;
    @Email
    @NotEmpty
    private String userEmail;
    @NotEmpty
    private String userName;
}