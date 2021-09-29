import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

class EMP{
    int max, value, blan;
    HashMap<String, Integer> map = new HashMap<>();


    public EMP(int blan, int max, int value) {
        this.blan = blan;
        this.max = max;
        this.value = value;
    }
}

public class mid_5 {
    public static void main(String [] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        boolean flag = true;

        Stack<EMP> stack = new Stack<>();
        stack.push(new EMP(1, 0, 0));

        while((input = br.readLine()) != null) {
            String [] le = input.split(" ");
            for(int i = 0; i < le.length; i++) {
                String k = le[i].toLowerCase();
                if (k.equals("")) {
                    continue;
                }
                if (k.equals("(") || k.equals("{") || k.equals("[")) {
                    if (k.equals("(")) {
                        stack.push(new EMP(2, 0, 0));
                    } else if (k.equals("{")) {
                        stack.push(new EMP(3, 0, 0));
                    } else if (k.equals("[")) {
                        stack.push(new EMP(4, 0, 0));
                    }
                } else if (k.equals(")")) {
                    if (stack.peek().blan != 2) {
                        flag = false;
                    } else {
                        int tmp = (stack.peek().max + stack.peek().value) * stack.peek().blan;
                        stack.pop();
                        stack.peek().value += tmp;
                    }
                } else if (k.equals("}")) {
                    if (stack.peek().blan != 3) {
                        flag = false;
                    } else {
                        int tmp = (stack.peek().max + stack.peek().value) * stack.peek().blan;
                        stack.pop();
                        stack.peek().value += tmp;
                    }
                } else if (k.equals("]")) {
                    if (stack.peek().blan != 4) {
                        flag = false;
                    } else {
                        int tmp = (stack.peek().max + stack.peek().value) * stack.peek().blan;
                        stack.pop();
                        stack.peek().value += tmp;
                    }
                } else {   //단어인 경우
                    if (stack.peek().map.containsKey(k)) {
                        int tmp = stack.peek().map.get(k);
                        stack.peek().map.put(k, tmp + 1);
                        stack.peek().max = Math.max(stack.peek().max, tmp + 1);
                    } else {
                        stack.peek().map.put(k, 1);
                        if (stack.peek().max == 0) {
                            stack.peek().max = 1;
                        }
                    }

                }
            }

        }


        if(stack.peek().blan != 1){
            flag = false;
        }
        int result = stack.peek().max + stack.pop().value;
        if(flag) {
            System.out.println(result);
        }
        else{
            System.out.println(-1);
        }

    }
}
