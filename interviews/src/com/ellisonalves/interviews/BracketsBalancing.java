package com.ellisonalves.interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketsBalancing {

    private Map<String, String> characters = new HashMap<>();

    public BracketsBalancing() {
        characters.put("{", "}");
        characters.put("(", ")");
        characters.put("[", "]");
    }

    boolean solveBrackets(String input) {
        Stack<String> openingCharsStack = new Stack<>();
        char[] inputAsCharArray = input.toCharArray();
        for (int i = 0; i < inputAsCharArray.length; i++) {
            String currentChar = String.valueOf(inputAsCharArray[i]);
            if (isAnOpeningChar(currentChar))
                openingCharsStack.push(currentChar);

            if (!openingCharsStack.isEmpty()) {
                String nextClosingChar = characters.get(openingCharsStack.peek());
                if (nextClosingChar.equals(currentChar))
                    openingCharsStack.pop();
            }
        }
        boolean result = openingCharsStack.empty();
        System.out.println("Input: " + input + " => Result: " + result);
        return result;
    }

    private boolean isAnOpeningChar(String aChar) {
        return characters.containsKey(aChar);
    }

    public static void main(String... args) {
        BracketsBalancing bb = new BracketsBalancing();
        bb.solveBrackets("({})");
        bb.solveBrackets("][}{)(");
        bb.solveBrackets("(){}[]");
        bb.solveBrackets("([)]");
        bb.solveBrackets("((()))");
        bb.solveBrackets("[[[]]]");
        bb.solveBrackets("{{{}}}");
        bb.solveBrackets("[([{}])]");
    }

}
