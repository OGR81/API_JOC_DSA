package edu.upc.dsa.exceptions;

public class UserNotAddedException extends Exception{
        public UserNotAddedException() {
            super();
        }

        public UserNotAddedException(String message) {
            super(message);
        }
}
