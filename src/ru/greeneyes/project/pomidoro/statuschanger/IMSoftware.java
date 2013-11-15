package ru.greeneyes.project.pomidoro.statuschanger;

public enum IMSoftware {

    ADIUM("Adium") {

        @Override
        protected String getGoAwayWithMessage(String message) {
            return String.format("to go away with message \"%s\"", message);
        }

        @Override
        protected String getGoAwayWithoutMessage() {
            return "to go away";
        }

        @Override
        protected String getAvailableWithoutMessage() {
            return "to go available";
        }

        @Override
        protected String getAvailableWithMessage(String message) {
            return String.format("to go available with message \"%s\"", message);
        }
    }, MESSAGES("Messages") {

        @Override
        protected String getGoAwayWithMessage(String message) {
            return String.format("\nset status to away\nset status message to \"%s\"\nend tell", message);
        }

        @Override
        protected String getGoAwayWithoutMessage() {
            return "\nset status to away\nend tell";
        }

        @Override
        protected String getAvailableWithoutMessage() {
            return "\nset status to available\nend tell";
        }

        @Override
        protected String getAvailableWithMessage(String message) {
            return String.format("\nset status to available\nset status message to \"%s\"\nend tell", message);
        }
    };

    private String name;

    private IMSoftware(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract String getGoAwayWithMessage(String message);
    protected abstract String getGoAwayWithoutMessage();
    protected abstract String getAvailableWithoutMessage();
    protected abstract String getAvailableWithMessage(String message);

}
