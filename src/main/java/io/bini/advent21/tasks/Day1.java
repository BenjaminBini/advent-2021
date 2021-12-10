package io.bini.advent21.tasks;

import java.util.List;
import java.util.logging.Logger;

public class Day1 extends DayBase {

    @Override
    public String getDayName() {
        return "1";
    }

    @Override
    public Integer task1() {
        List<Integer> input = getInputLinesAsIntegers();
        int result = 0;
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) > input.get(i - 1)) {
                result = result + 1;
            }
        }
        return result;
    }

    @Override
    public Integer task2() {
        List<Integer> input = getInputLinesAsIntegers();
        int result = 0;
        for (int i = 0; i < input.size() - 3; i++) {
            int sum1 = input.get(i) + input.get(i + 1) + input.get(i + 2);
            int sum2 = input.get(i + 1) + input.get(i + 2) + input.get(i + 3);
            if (sum2 > sum1) {
                result = result + 1;
            }
        }
        return result;
    }


}
