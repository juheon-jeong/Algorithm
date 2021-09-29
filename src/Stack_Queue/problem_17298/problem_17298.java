package Stack_Queue.problem_17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;



public class problem_17298 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstline = br.readLine();
        int firstline_int = Integer.parseInt(firstline);
        int[] test_array = new int[firstline_int];
        String[] secondline = br.readLine().split(" ");  //두번째 줄 입력
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i< firstline_int; i++) {  //값 저장
            test_array[i] = Integer.parseInt(secondline[i]);
        }

        for(int i = 0; i < firstline_int; i++) {
            while(!stack.isEmpty() && test_array[stack.peek()] < test_array[i]){
                        test_array[stack.pop()] = test_array[i];
                }

            stack.push(i);
            }

        while(!stack.isEmpty()) {
            test_array[stack.pop()] = -1;
        }

        for(int i : test_array) {
            sb.append(i +" ");
        }
        String overcome = sb.toString();
        System.out.println(overcome);


    }
}
