package io.bini.advent21.tasks;

import java.util.List;
import java.util.logging.Logger;

public interface Day {
    public String getDayName();

    public Integer task1();

    public Integer task2();

    public Logger getLogger();

    public void print();
}
