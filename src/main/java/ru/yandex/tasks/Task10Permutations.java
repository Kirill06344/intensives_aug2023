package ru.yandex.tasks;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Task10Permutations {
    public static int[][] permutations(int[] numbers) {
        var resultInList = perms(Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList()));

        int [][] result = new int[resultInList.size()][];
        for (int i = 0; i < resultInList.size(); ++i) {
            result[i] = resultInList.get(i).stream().mapToInt(el -> el).toArray();
        }
        return result;
    }


    public static List<List<Integer>> perms(List<Integer> numbers) {
        List<List<Integer>> res = new LinkedList<>();
        if (numbers.size() == 2) {
            List<Integer> firstPerm = new ArrayList<>();
            firstPerm.add(numbers.get(0));
            firstPerm.add(numbers.get(1));
            List<Integer> secondPerm = new ArrayList<>();
            secondPerm.add(numbers.get(1));
            secondPerm.add(numbers.get(0));
            res.add(firstPerm);
            res.add(secondPerm);
            return res;
        }
        for (int i = 0; i < numbers.size(); ++i) {
            List<Integer> copyWithoutElement = new ArrayList<>();
            copyWithoutElement.addAll(numbers);
            copyWithoutElement.remove(i);
            var recurseResult = perms(copyWithoutElement);
            for (var l : recurseResult) {
                l.add(0, numbers.get(i));
            }
            res.addAll(recurseResult);
        }
        return res;
    }


    public static void selfCheck() {
        int[] input = {1, 2, 3};
        int[][] output = {
                {1, 2, 3},
                {1, 3, 2},
                {2, 1, 3},
                {2, 3, 1},
                {3, 1, 2},
                {3, 2, 1}
        };

        assert Arrays.deepEquals(output, permutations(input));
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
