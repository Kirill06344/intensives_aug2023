package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3InsertionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); ++i) {
            int j = i;
            while (j > 0 && numbers.get(j) < numbers.get(j - 1)) {
                swap(numbers, j, j - 1);
                j--;
            }
        }
        return numbers;
    }



    public static void swap(ArrayList<Integer> numbers, int i, int j) {
        Integer tmp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, tmp);
    }


    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 6,  4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assert output.equals(sort(input));
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
