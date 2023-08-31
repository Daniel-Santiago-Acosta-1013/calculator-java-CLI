// src/Calculator.java

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public double evaluate(String input) throws Exception {
        Queue<String> postfix = infixToPostfix(input);
        return evaluatePostfix(postfix);
    }

    private int getPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private Queue<String> infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        Queue<String> result = new LinkedList<>();
        String number = "";

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                number += c;
            } else {
                if (!number.isEmpty()) {
                    result.add(number);
                    number = "";
                }

                switch (c) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '^':
                        while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                            result.add(String.valueOf(stack.pop()));
                        }
                        stack.push(c);
                        break;
                    case '(':
                        stack.push(c);
                        break;
                    case ')':
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            result.add(String.valueOf(stack.pop()));
                        }
                        if (!stack.isEmpty() && stack.peek() != '(') {
                            return null; // Invalid expression
                        } else {
                            stack.pop();
                        }
                        break;
                }
            }
        }

        if (!number.isEmpty()) {
            result.add(number);
        }

        while (!stack.isEmpty()) {
            result.add(String.valueOf(stack.pop()));
        }

        return result;
    }

    private double evaluatePostfix(Queue<String> postfix) throws Exception {
        Stack<Double> stack = new Stack<>();

        while (!postfix.isEmpty()) {
            String token = postfix.poll();

            if (Character.isDigit(token.charAt(0))) {
                stack.push(Double.parseDouble(token));
            } else {
                double num2 = stack.pop();
                double num1 = stack.pop();

                switch (token.charAt(0)) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new Exception("Error: División por cero.");
                        }
                        stack.push(num1 / num2);
                        break;
                    case '^':
                        stack.push(Math.pow(num1, num2));
                        break;
                }
            }
        }
        return stack.pop();
    }
}