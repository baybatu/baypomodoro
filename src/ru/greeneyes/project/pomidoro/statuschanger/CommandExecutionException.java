package ru.greeneyes.project.pomidoro.statuschanger;

public class CommandExecutionException extends RuntimeException {

    public CommandExecutionException(String message) {
        super(message);
    }

    public CommandExecutionException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CommandExecutionException(Throwable throwable) {
        super(throwable);
    }
}
