package ru.greeneyes.project.pomidoro.statuschanger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecuter {

    public String exec(String command) {
        Runtime runtime = Runtime.getRuntime();
        String[] args = { "osascript", "-e", command};
        try {
            Process exec = runtime.exec(args);
            BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            return br.readLine();
        } catch (IOException e) {
            throw new CommandExecutionException(e);
        }

    }

}