package org.example.exception;

    public class InvalidMenuActionException extends RuntimeException {
        public InvalidMenuActionException(String message) {
            super(message);
        }
    }

