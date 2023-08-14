package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task1BubbleSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        boolean flag = true;
        int size = numbers.size();
        while (flag) {
            flag = false;
            for (int i = 1; i < size; ++i) {
                if (numbers.get(i) > numbers.get(i - 1)) {
                    swap(numbers, i, i - 1);
                    flag = true;
                }
            }
            size--;
        }

        return numbers;
    }

    public static void swap(ArrayList<Integer> numbers, int i, int j) {
        Integer tmp = numbers.get(i);
        numbers.set(i, tmp);
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
