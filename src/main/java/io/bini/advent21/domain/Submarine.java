package io.bini.advent21.domain;

import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Submarine {
    private static final Logger LOGGER = Logger.getLogger(
            Thread.currentThread().getStackTrace()[0].getClassName());

    private int depth = 0;

    private int position = 0;

    private int aim = 0;


    public int getDepth() {
        return depth;
    }

    public int getPosition() {
        return position;
    }

    private void command(String command, Integer units) {
        switch (command) {
            case "forward" -> position = position + units;
            case "down" -> depth = depth + units;
            case "up" -> depth = depth - units;
        }
    }

    private void wrongCommand(String command, Integer units) {
        switch (command) {
            case "forward" -> {
                position = position + units;
                depth = depth + (aim * units);
            }
            case "down" -> aim = aim + units;
            case "up" -> aim = aim - units;

        }
    }

    private void command(String commandWithUnits, BiConsumer<String, Integer> function) {
        String[] commandParts = commandWithUnits.split(" ");
        if (commandParts.length != 2 || !commandParts[0].equals("forward") && !commandParts[0].equals("down") && !commandParts[0].equals("up")) {
            LOGGER.log(Level.SEVERE, "Wrong command");
            return;
        }
        try {
            int units = Integer.parseInt(commandParts[1]);
            function.accept(commandParts[0], units);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Command unit is not a number");
            e.printStackTrace();
        }
    }

    public void wrongCommand(String commandWithUnits) {
        this.command(commandWithUnits, this::wrongCommand);
    }

    public void command(String commandWithUnits) {
        this.command(commandWithUnits, this::command);
    }
}
