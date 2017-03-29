package com.hucet.user.exception;

/**
 * Created by taesu on 2017-02-28.
 */
public class UserNotFoundException extends AbstractRestException {

    public UserNotFoundException(String s) {
        super(s);
    }
}
