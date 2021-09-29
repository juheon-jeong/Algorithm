package Stack_Queue.problem_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class problem_2493 {
    public static void main(String [] args) throws IOException {

        Stack<Top> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int [] ex_array = new int[size];
        String[] test = br.readLine().split(" ");
        int [] result = new int[size];
        StringBuilder sb = new StringBuilder();



        for (int i = 0; i < size; i++) {                 //배열 값 저장...
            ex_array[i] = Integer.parseInt(test[i]);
        }
        for(int i = 0; i < size; i++) {

            while(!stack.isEmpty() && stack.peek().height < ex_array[i]) {
                stack.pop();
            }

            if(stack.isEmpty()){
                result[i] = 0;
            }else {
                result[i] = stack.peek().idx + 1;
            }

            stack.add(new Top(i, ex_array[i]));
        }

        for(int i : result) {
            sb.append(i+ " ");
        }
        String overcome = sb.toString();
        System.out.println(overcome);
    }

    public static class Top{
        int idx, height;

        Top(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
