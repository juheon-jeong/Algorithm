package preparefinal;
import java.util.*;
import java.io.*;

class Cell {
    int index, value;

    public Cell (int index, int value) {
        this.index = index;
        this.value = value;
    }
}


public class Solution {
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack <Cell> stack = new Stack<>();

        int tc = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < tc; i++) {
            String [] line = br.readLine().split(" ");

            if(line[0].equals("Push")) {
                count++;
                int value = Integer.parseInt(line[1]);
                if(stack.isEmpty()) {
                    stack.push(new Cell(count, value));
                }
                else if( value > stack.peek().value){
                    stack.push(new Cell(count, value));
                }
                else{
                    stack.push(new Cell(stack.peek().index, stack.peek().value));
                }
            }

            else {
                System.out.println(stack.peek().index + " " + stack.pop().value);

            }
        }
    }
}
