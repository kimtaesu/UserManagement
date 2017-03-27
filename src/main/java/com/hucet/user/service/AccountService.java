package com.hucet.user.service;

import com.hucet.user.domain.Account;
import com.hucet.user.dto.AccountDto;
import com.hucet.user.exception.AlreadyRegisteredException;
import com.hucet.user.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Slf4j
@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;

    public Account newAccount(AccountDto dto) {
        if (accountRepository.findByUserEmail(dto.getUserEmail()).isPresent()) {
            throw new AlreadyRegisteredException("이미 등록된 사용자입니다.");
        }
        Account account = modelMapper.map(dto, Account.class);
        account = accountRepository.save(account);
        return account;
    }
}
