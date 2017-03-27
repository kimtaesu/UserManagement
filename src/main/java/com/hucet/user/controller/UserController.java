package com.hucet.user.controller;

import com.hucet.user.service.AccountService;
import com.hucet.user.domain.Account;
import com.hucet.user.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/account")
public class UserController {

    @Autowired
    AccountService accountService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @RequestMapping(value = "/signup", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    Long signup(@RequestBody @Valid AccountDto dto, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result.toString());
        }

        Account account = accountService.newAccount(dto);
        return account.getId();
    }
}
