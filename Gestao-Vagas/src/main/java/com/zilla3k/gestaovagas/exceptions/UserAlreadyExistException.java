package com.zilla3k.gestaovagas.exceptions;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(){
        super("User already exist!");
    }
}
