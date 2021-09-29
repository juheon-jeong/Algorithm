import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class solution {
    public static void main(String[] args) throws  Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] firstline = br.readLine().split(" ");
        String sorg =  firstline[0];
        int number = Integer.parseInt(firstline[1]);

        if(sorg.equals("Stack")){
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < number; i++){
                String[] choice = br.readLine().split(" ");
                    if(Integer.parseInt(choice[0]) == 0){
                        System.out.println(stack.size());
                    }
                    else if(Integer.parseInt(choice[0]) == 1){
                        System.out.println(stack.peek());
                    }
                    else if(Integer.parseInt(choice[0]) == 2){
                        stack.pop();
                    }else if(Integer.parseInt(choice[0]) == 3) {
                        stack.push(Integer.parseInt(choice[1]));
                    }
            }

        }

        if(sorg.equals("Queue")){
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < number; i++){
                String[] choice = br.readLine().split(" ");
                if(Integer.parseInt(choice[0]) == 0){
                    System.out.println(queue.size());
                }
                else if (Integer.parseInt(choice[0]) == 1){
                    System.out.println(queue.peek());
                }
                else if(Integer.parseInt(choice[0]) == 2){
                    queue.poll();
                }
                else if (Integer.parseInt(choice[0]) == 3){
                    queue.offer(Integer.parseInt(choice[1]));
                }
            }
        }


    }
}