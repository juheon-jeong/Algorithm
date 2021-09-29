import java.util.*;
import java.io.*;


public class compare {

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input =br.readLine();
        String output = convert(input);

        long output2 = calculator(output);

        System.out.println(output);
        System.out.println(output2);


    }
    static String convert(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] firstline = s.split(" ");

        for (int i = 0; i < firstline.length; i++) {
            String k = firstline[i];
            int pri = priority(k);
            if (k.equals("^") || k.equals("*") || k.equals("/") || k.equals("%") || k.equals("+") || k.equals("-")) {
                while (!stack.isEmpty() && priority(stack.peek()) >= pri) {
                    sb.append(stack.pop() + " ");
                }
                stack.push(k);
            } else if (k.equals("(")) {
                stack.push(k);
            } else if (k.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    sb.append(stack.pop() + " ");
                }
                stack.pop();
            } else {
                sb.append(k + " ");
            }


        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }


        String result = sb.toString();
        return result;

    }

    static long calculator(String s) {
        String[] input = s.split(" ");
        int len = input.length;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i< len; i++) {
            String ch = input[i];
            int p = priority(ch);

            if(p == -1) {
                stack.push(ch);
            }
            else {
                long num1 = Long.parseLong(stack.pop());
                long num2 = Long.parseLong(stack.pop());

                switch(ch) {
                    case "+" :
                        stack.push(Long.toString( num2 + num1));
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

    static int priority(String x){
        if(x.equals("^")) {
            return 3;
        }
        else if(x.equals("*") || x.equals("/") || x.equals("%")) {
            return 2;
        }
        else if(x.equals("+") || x.equals("-")){
            return 1;
        }
        else if(x.equals("(") || x.equals(")")){
            return 0;
        }
        else {
            return -1;
        }
    }
}