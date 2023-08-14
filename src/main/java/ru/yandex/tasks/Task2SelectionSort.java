package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2SelectionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); ++i) {
            int min = numbers.get(i);
            int inxOfMin = i;
            for (int j = i + 1; j < numbers.size(); ++j) {
                if (numbers.get(j) < min) {
                    min = numbers.get(j);
                    inxOfMin = j;
                }
            }
            swap(numbers, i, inxOfMin);
        }
        return numbers;
    }

    public static void swap(ArrayList<Integer> numbers, int i, int j) {
        Integer tmp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, tmp);
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
