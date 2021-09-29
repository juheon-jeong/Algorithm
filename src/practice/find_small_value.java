package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class find_small_value {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstline = br.readLine();
        Stack<Cell> stack = new Stack<>();
        int firstline_i = Integer.parseInt(firstline);
        int index = 0;

        for (int i = 0; i < firstline_i; i++) {
            String[] choice = br.readLine().split(" ");
            String doing = choice[0];
            if (doing.equals("Push")) {
                index++;
                if (stack.isEmpty()) {
                    stack.push(new Cell(index, Integer.parseInt(choice[1])));
                } else {
                    if (stack.peek().number < Integer.parseInt(choice[1])) {
                        stack.push(new Cell(stack.peek().index, stack.peek().number));
                    } else {
                        stack.push(new Cell(index, Integer.parseInt(choice[1])));
                    }
                }
            } else {
                int k = stack.peek().index;
                int m = stack.peek().number;
                stack.pop();

                System.out.println(k + " " + m);;


            }
        }
    }


        static class Cell {
            int index, number;

            public Cell(int index, int number) {
                this.index = index;
                this.number = number;
            }
        }
    }

