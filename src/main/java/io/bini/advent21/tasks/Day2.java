package io.bini.advent21.tasks;

import io.bini.advent21.domain.Submarine;

import java.util.List;

public class Day2 extends DayBase{
    @Override
    public String getDayName() {
        return "2";
    }

    @Override
    public Integer task1() {
        List<String> input = getInputLines();
        Submarine submarine = new Submarine();
        for (String commandWithUnit : input) {
            submarine.command(commandWithUnit);
        }
        return submarine.getDepth() * submarine.getPosition();
    }

    @Override
    public Integer task2() {
        List<String> input = getInputLines();
        Submarine submarine = new Submarine();
        for (String commandWithUnit : input) {
            submarine.wrongCommand(commandWithUnit);
        }
        return submarine.getDepth() * submarine.getPosition();
    }
}
