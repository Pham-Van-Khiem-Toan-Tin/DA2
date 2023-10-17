package com.shopecommerce.exception;

import org.springframework.security.core.AuthenticationException;

public class UsernameNotActiveException extends AuthenticationException {
    public UsernameNotActiveException(String msg) {
        super(msg);
    }

    public UsernameNotActiveException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
