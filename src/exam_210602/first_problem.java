package exam_210602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class first_problem {

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pri = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;

        int purpose = Integer.parseInt(br.readLine());
        String [] line = br.readLine().split(" ");
        for(int i = 0; i < line.length; i++) {
            pri.add(Integer.parseInt(line[i]));
        }

        while(!pri.isEmpty() && pri.peek() > purpose){
            int temp1 = pri.peek() / 3; // 3분의 1값
            int temp2 = pri.peek() * 2 / 3; //3분의 2값
            pri.add(temp1);
            pri.add(temp2);
            pri.poll();
            count ++;
        }
        System.out.println(count);
    }
}
