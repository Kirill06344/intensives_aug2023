package ru.yandex.tasks;

import java.util.Deque;
import java.util.LinkedList;

public class Task6BraceBalance {
    public static boolean checkBalance(String sequence) {
        Deque<Character> stack = new LinkedList<>();
        String leftBraces = "[({";
        for (int i = 0; i < sequence.length(); ++i) {
            char cur = sequence.charAt(i);
            if (leftBraces.indexOf(cur) != -1) {
                if (cur == '[') {
                    stack.addFirst(']');
                } else if (cur == '{') {
                    stack.addFirst('}');
                } else {
                    stack.addFirst(')');
                }
            } else {
                if (stack.isEmpty() || stack.peek() != cur) {
                    return false;
                }
                stack.removeFirst();
            }
        }
        return stack.isEmpty();
    }

    public static void selfCheck() {
        String test1 = "[({})]{[]}";
        String test2 = "{({})}{";

        assert checkBalance(test1);
        assert !checkBalance(test2);
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
