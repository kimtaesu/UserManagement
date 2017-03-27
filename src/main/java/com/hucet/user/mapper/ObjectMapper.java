package com.hucet.user.mapper;

import com.hucet.user.domain.Account;
import com.hucet.user.dto.AccountDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

import javax.annotation.PostConstruct;

@Configuration
public class ObjectMapper extends ModelMapper {
    @PostConstruct
    void init() {

    }

    public Account toAccount(AccountDto dto) {
        return null;
    }
}
