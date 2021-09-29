package practice_210602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class problem_1927 {
    public static void main(String[] args) throws IOException{

        PriorityQueue<Integer> pri = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcase; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0  && pri.isEmpty()) {
                System.out.println(0);
            }
            else if(num == 0) {
                System.out.println(pri.poll());
            }
            else{
                pri.add(num);
            }
        }
    }
}
