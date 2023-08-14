package ru.yandex.tasks;

public class Task8BinarySearch {
    public static int find(int number, int[] sortedList) {
        /*
         * number: целое число, -10^5 <= number <= 10^5
         * numbers: массив целых чисел, 0 <= numbers.length <= 10^5 (числа не повторяются)
         * Выход: i, где numbers[i] = number, -1, если такого i нет
         * Если таких i несколько, вывести наибольший
         */

        int l = 0, r = sortedList.length;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (number < sortedList[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return number == sortedList[l] ? l : -1;
    }

    public static void selfCheck() {
        int[] input = {1, 3, 5, 7, 9};

        for (int i = 0; i < input.length; i++) {
            assert (find(input[i], input) == i);
        }

        input = new int[]{1, 4, 7, 7, 7, 9, 9};
        assert (find(7, input) == 4);
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
