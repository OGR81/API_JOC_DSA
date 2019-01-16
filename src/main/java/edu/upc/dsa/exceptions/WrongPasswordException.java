package edu.upc.dsa.exceptions;

public class WrongPasswordException extends Exception {

    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}


