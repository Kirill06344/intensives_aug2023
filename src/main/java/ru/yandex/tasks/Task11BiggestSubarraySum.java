package ru.yandex.tasks;

public class Task11BiggestSubarraySum {

    public static Subarray find(int[] numbers) {
        /*
         * Находит подмассив (подряд идущие элементы массива) с наибольшей суммой элементов
         * numbers: массив целых чисел, -10^5 <= numbers[i] <= 10^5, длина массива до 10^5
         * Выход: Subarray
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        Subarray subarray = new Subarray();
        int answer = 0, prefSum = 0, minPrefSum = 0, inxOfMinPrefSum = 0;
        for (int i = 0; i < numbers.length; ++i) {
            prefSum += numbers[i];
            int currSum = prefSum - minPrefSum;
            if (currSum > answer) {
                subarray.left = inxOfMinPrefSum;
                subarray.right = i + 1;
                answer = currSum;
            }
            if (prefSum < minPrefSum) {
                minPrefSum = prefSum;
                inxOfMinPrefSum = i + 1;
            }
        }
        return subarray;
    }

    public static void selfCheck() {
        int[] output = {1, 2, -5, 7, -1, 6};
        Subarray ans = find(output);

        assert ans != null;
        assert (ans.left == 3 && ans.right == 6);
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
