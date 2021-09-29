package practice_210602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_11286 {
    public static void main(String [] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> prq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                int abo1 = Math.abs(o1);
                int abo2 = Math.abs(o2);

                if(abo1 == abo2) {
                    return o1 - o2;
                }
                return abo1 - abo2;
            }
        });

        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(prq.isEmpty()) {
                    System.out.println(0);
                }else{
                    System.out.println(prq.poll());
                }

            }
            else{
                prq.add(num);
            }
        }


    }
}
