package com.babayan.homeworks.homework_17;

import java.util.HashMap;
import java.util.Stack;

public class JsonValidator {
    public static boolean isValid(String s) {
        if (s.charAt(0) != '{') {
            return false;
        }
        HashMap<Character, Character> maps = new HashMap<>();
        maps.put(']', '[');
        maps.put(')', '(');
        maps.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (maps.containsKey(c)) {
                if (stack.empty() || stack.pop() != maps.get(c)) return false;
            } else if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}