package ru.greeneyes.project.pomidoro.statuschanger;

public class CommandGenerator {

    public String generateGoAwayCommand(IMSoftware software, String... messages) {
        String message;
        if (messages.length == 0) {
            message = software.getGoAwayWithoutMessage();
        } else {
            message = software.getGoAwayWithMessage(messages[0]);
        }
        return String.format("tell application \"%s\" %s", software.getName(), message);
    }

    public String generateAvailableCommand(IMSoftware software, String... messages) {
        String message;
        if (messages.length == 0) {
            message = software.getAvailableWithoutMessage();
        } else {
            message = software.getAvailableWithMessage(messages[0]);
        }
        return String.format("tell application \"%s\" %s", software.getName(), message);
    }
}
