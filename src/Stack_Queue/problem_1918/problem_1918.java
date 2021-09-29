package Stack_Queue.problem_1918;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class problem_1918 {
    static Stack<String> stack = new Stack<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] test = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        String [] sic = new String[test.length];
        for(int i=0; i<test.length ; i++){
             sic[i] = test[i];
        }

        for(int i=0; i<sic.length; i++){
            if(sic[i].equals("*") || sic[i].equals("/") || sic[i].equals("+") || sic[i].equals("-")){

                while (!stack.isEmpty() && priority(sic[i]) <= priority(stack.peek())){
                    String k =stack.pop();
                    sb.append(k);
                }

                stack.push(sic[i]);
            }
            else if(sic[i].equals("(")){
                stack.push(sic[i]);
            }else if(sic[i].equals(")")){
                while(!stack.peek().equals("(")){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else{
                sb.append(sic[i]);
            }
       }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        String result = sb.toString();
        System.out.println(result);
    }

    static int priority(String calc) {
        if(calc.equals("*") || calc.equals("/") ){
            return 2;
        }
        else if(calc.equals("+")  || calc.equals("-")){
            return 1;

        }else if(calc.equals("(") || calc.equals(")")){
            return 0;
        }else{
            return -1;
        }
    }
}
