package ru.greeneyes.project.pomidoro.statuschanger;

import java.util.ArrayList;
import java.util.List;

public class IMSoftwareFinder {

    private CommandExecuter commandExecuter;

    private String finderCommandTemplate = "tell application \"System Events\" " +
            "to (count of (every process whose name is \"%s\")) > 0";

    public IMSoftwareFinder(CommandExecuter commandExecuter) {
        this.commandExecuter = commandExecuter;
    }

    public List<IMSoftware> getAvailableSoftwares() {
        List<IMSoftware> availableSoftwares = new ArrayList<IMSoftware>();
        for (IMSoftware imSoftware : IMSoftware.values()) {
            String returnValue = commandExecuter.exec(String.format(finderCommandTemplate, imSoftware.getName()));
            if ("true".equals(returnValue)) {
                availableSoftwares.add(imSoftware);
            }
        }
        return availableSoftwares;
    }
}
