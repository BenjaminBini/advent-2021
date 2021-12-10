package io.bini.advent21.tasks;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Day3 extends DayBase {
    @Override
    public String getDayName() {
        return "3";
    }

    @Override
    public Integer task1() {
        List<String> input = getInputLines();
        int numberLength = getInputLines().get(0).length();

        int[] numberOfOnes = new int[numberLength];
        for (int i = 0; i < numberLength; i++) {
            numberOfOnes[numberLength - i - 1] = countBitAtIndex(input, i, 1);
        }
        BitSet gammaBits = new BitSet(numberLength);
        BitSet epsilonBits = new BitSet(numberLength);
        for (int i = 0; i < numberLength; i++) {
            if (numberOfOnes[i] > input.size() / 2) {
                gammaBits.set(i);
            } else {
                epsilonBits.set(i);
            }
        }
        long gamma = gammaBits.toLongArray()[0];
        long epsilon = epsilonBits.toLongArray()[0];
        return (int) (gamma * epsilon);
    }

    @Override
    public Integer task2() {
        List<String> input = getInputLines();
        int oxygenRating = getOxygenRating(input);
        int scrubberRating = getScrubberRating(input);
        return scrubberRating * oxygenRating;
    }

    private int getOxygenRating(List<String> input) {
        List<String> remainingInput = new ArrayList<>(input);
        int index = 0;
        do {
            remainingInput = oxygenRatingCriteriaFilter(remainingInput, index);
            index++;
        } while(remainingInput.size() > 1);
        long oxygenRating = binaryStringToLong(remainingInput.get(0));
        return (int) oxygenRating;
    }

    private int getScrubberRating(List<String> input) {
        List<String> remainingInput = new ArrayList<>(input);
        int index = 0;
        do {
            remainingInput = scrubberRatingFilter(remainingInput, index);
            index++;
        } while(remainingInput.size() > 1);
        long oxygenRating = binaryStringToLong(remainingInput.get(0));
        return (int) oxygenRating;
    }

    private long binaryStringToLong(String input) {
        BitSet bitSet = new BitSet(input.length());
        for (int i = 0; i < input.length(); i++) {
            bitSet.set(input.length() - i - 1, input.charAt(i) == '1');
        }
        return bitSet.toLongArray()[0];
    }

    private int countBitAtIndex(List<String> input, int bitIndex, int value) {
        return input.stream()
                .map(s -> Integer.parseInt(s.substring(bitIndex, bitIndex + 1)))
                .reduce(0, (acc, c) -> c == value ? acc + 1 : acc);
    }

    private List<String> oxygenRatingCriteriaFilter(List<String> input, int bitIndex) {
        int numberOfOnes = this.countBitAtIndex(input, bitIndex, 1);
        if (numberOfOnes >= input.size() / 2.) {
            return input.stream().filter(s -> s.charAt(bitIndex) == '1').toList();
        } else {
            return input.stream().filter(s -> s.charAt(bitIndex) == '0').toList();
        }
    }

    private List<String> scrubberRatingFilter(List<String> input, int bitIndex) {
        int numberOfOnes = this.countBitAtIndex(input, bitIndex, 1);
        if (numberOfOnes < input.size() / 2.) {
            return input.stream().filter(s -> s.charAt(bitIndex) == '1').toList();
        } else {
            return input.stream().filter(s -> s.charAt(bitIndex) == '0').toList();
        }
    }
}
