package five_week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class basic_queue {

    public static void main(String [] args) throws  Exception{
        Queue<Integer> queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstline = br.readLine();

        int firstline_i = Integer.parseInt(firstline);

        for(int i=0; i < firstline_i; i++) {
            String[] k = br.readLine().split(" ");
            if(k.length == 2){
                int doing = Integer.parseInt(k[0]);
                int number = Integer.parseInt(k[1]);

                if(doing == 1) {
                    queue.offer(number);
                }
            }
            if(Integer.parseInt(k[0]) == 2){
                queue.poll();
            }
            else if(Integer.parseInt(k[0]) == 3){
                System.out.println(queue.peek());
            }

        }
    }
}
