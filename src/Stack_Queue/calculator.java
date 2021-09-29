package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String output = convertPostfix(input);
        System.out.println(output);
        long output2 = calculator(output);
        System.out.println(output2);
    }

    public static String convertPostfix(String s) {
        String[] input = s.split(" ");
        int len = input.length;
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            String ch = input[i].trim();
            int p = priority(ch);
            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("%")
                    || ch.equals("^")) {
                while (!stack.isEmpty() && priority(stack.peek()) >= p) {
                    sb.append(stack.pop() + " ");
                }
                stack.push(ch);
            } else if (ch.equals("(")) {
                stack.push(ch);
            } else if (ch.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    sb.append(stack.pop() + " ");
                }
                stack.pop();
            } else {
                sb.append(ch + " ");
            }

        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        String result = sb.toString();

        return result;
    }

    public static int priority(String s) {
        if (s.equals("^")) {
            return 3;
        } else if (s.equals("*") || s.equals("/") || s.equals("%")) {
            return 2;
        } else if (s.equals("+") || s.equals("-")) {
            return 1;
        } else if (s.equals("(") || s.equals(")")) {
            return 0;
        } else {
            return -1;
        }
    }

    public static long calculator(String s) {
        String[] input = s.split(" ");
        int len = input.length;
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < len; i++) {
            String ch = input[i].trim();
            int p = priority(ch);
            if (p == -1) {
                stack.push(ch);
            } else {
                long num1 = Long.parseLong(stack.pop());
                long num2 = Long.parseLong(stack.pop());

                switch (ch) {
                    case "+":
                        stack.push(Long.toString(num2 + num1));
                        break;
                    case "-":
                        stack.push(Long.toString(num2 - num1));
                        break;
                    case "*":
                        stack.push(Long.toString(num2 * num1));
                        break;
                    case "/":
                        stack.push(Long.toString(num2 / num1));
                        break;
                    case "%":
                        stack.push(Long.toString(num2 % num1));
                        break;
                    case "^":
                        stack.push(Long.toString(Math.round(Math.pow(num2, num1))));
                        break;
                }
            }
        }
        return Long.parseLong(stack.pop());
    }
}