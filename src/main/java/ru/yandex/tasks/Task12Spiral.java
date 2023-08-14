package ru.yandex.tasks;

import java.util.Arrays;

public class Task12Spiral {
    public static int[][] draw (int n) {
        /*
         * Отрисовывает "спираль" в двумерном массиве по часовой стрелке
         * -10^3 <= N <= 10^3
         * Выход: массив со спиралью
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        int [][] result = new int[n][n];
        int [][] move  =  {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int moveType = 0;
        int i = 0, j = 0;
        for (int number = 1; number <= n * n; number++) {
            result[i][j] = number;
            if (i + move[moveType][0] == n
                    || j + move[moveType][1] == -1
                    || j + move[moveType][1] == n
                    || result[i + move[moveType][0]][j + move[moveType][1]] != 0) {
                moveType = (moveType + 1) % 4;
            }
            i += move[moveType][0];
            j += move[moveType][1];
        }
        return result;
    }

    public static void selfCheck() {
        int[][] output = {
                {1, 2, 3, 4, 5, 6, 7},
                {24, 25, 26, 27, 28, 29, 8},
                {23, 40, 41, 42, 43, 30, 9},
                {22, 39, 48, 49, 44, 31, 10},
                {21, 38, 47, 46, 45, 32, 11},
                {20, 37, 36, 35, 34, 33, 12},
                {19, 18, 17, 16, 15, 14, 13}
        };

        assert Arrays.deepEquals(output, draw(7));
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
