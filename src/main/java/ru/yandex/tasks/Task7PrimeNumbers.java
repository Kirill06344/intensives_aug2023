package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task7PrimeNumbers {
    public static int[] findPrimes (int n) {
        List<Integer> res = new ArrayList<>();
        boolean [] primes = new boolean[n + 1];
        for (int i = 2; i <= n; ++i) {
            if (!primes[i]) {
                res.add(i);
                int j = 2;
                while (i * j <= n) {
                    primes[i * j] = true;
                    j++;
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void selfCheck() {
        int[] output = {2, 3, 5, 7, 11, 13, 17, 19, 23};

        assert (Arrays.equals(output, findPrimes(24)));
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
