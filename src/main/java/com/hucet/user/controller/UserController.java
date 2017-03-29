package com.hucet.user.controller;

import com.hucet.user.exception.UserNotFoundException;
import com.hucet.user.service.AccountService;
import com.hucet.user.domain.Account;
import com.hucet.user.dto.AccountDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Optional;

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

    @GetMapping("/info/{userEmail:.+}")
    ResponseEntity<Account> getUser(@PathVariable String userEmail) {
        if (accountService.getUser(userEmail).isPresent()) {
            return new ResponseEntity<Account>(accountService.getUser(userEmail).get(), HttpStatus.OK);
        }
        throw new UserNotFoundException("userEmail : " + userEmail + " 회원님은 존재하지 않습니다.");
    }
}
