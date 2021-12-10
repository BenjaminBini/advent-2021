package io.bini.advent21.tasks;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

public abstract class DayBase implements Day {
    File file;

    Logger logger;

    public List<Integer> getInputLinesAsIntegers() {
        return this.getInputLines().stream().mapToInt(Integer::valueOf).boxed().toList();
    }

    public List<String> getInputLines() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("day-%s".formatted(getDayName()));
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        return r.lines().toList();
    }

    @Override
    public Logger getLogger() {
        if (this.logger == null) {
            this.logger = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
        }
        return this.logger;
    }

    @Override
    public void print() {
        this.getLogger().info("Day %s - Task 1: %s".formatted(getDayName(), task1()));
        this.getLogger().info("Day %s - Task 2: %s".formatted(getDayName(), task2()));
    }
}
