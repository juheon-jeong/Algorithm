package Stack_Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class compiler {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        Stack<Character> stack = new Stack<>();
        boolean isTrue = true;
        boolean issmall = false;
        boolean islarge = false;

        while((input = br.readLine()) != null){
            String line = input;
            for(int i = 0; i < line.length(); i++){
                char temp = line.charAt(i);

                if(temp == '\''){
                    issmall = !issmall;
                }
                else if(temp == '\"'){
                    islarge = !islarge;
                }

                else if(temp == '{' || temp == '[' || temp == '('){
                    stack.push(temp);
                }
                else if(temp == '}'){
                    if(stack.isEmpty()){
                        isTrue = false;
                    }
                    else if(stack.peek() == '{'){
                        stack.pop();
                    }else{
                        isTrue = false;
                    }
                }
                else if(temp == ']'){
                    if(stack.isEmpty()){
                        isTrue = false;
                    }
                    else if(stack.peek() == '['){
                        stack.pop();
                    }else{
                        isTrue = false;
                    }
                }
                else if (temp == ')'){
                    if(stack.isEmpty()){
                        isTrue = false;
                    }
                    else if(stack.peek() == '('){
                        stack.pop();
                    }else{
                        isTrue = false;
                    }
                }


            }
        }

        if(isTrue || islarge || issmall){
            System.out.println("No Error");
        }else{
            System.out.println("Compile Error");
        }
    }
}

