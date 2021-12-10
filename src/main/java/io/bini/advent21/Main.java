package io.bini.advent21;

import io.bini.advent21.tasks.Day1;
import io.bini.advent21.tasks.Day2;
import io.bini.advent21.tasks.Day3;

import java.util.logging.Logger;

public class Main implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(
            Thread.currentThread().getStackTrace()[0].getClassName());

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    @Override
    public void run() {
        new Day1().print();
        new Day2().print();
        new Day3().print();
    }
}
