package practice_210602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class problem_11279 {

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue <Integer> priqueue = new PriorityQueue<>(Collections.reverseOrder());

        int testcase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcase; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && priqueue.isEmpty()) {
                System.out.println(0);
            }else if(num == 0) {
                System.out.println(priqueue.poll());
            }else{
                priqueue.add(num);
            }
        }
    }
}
