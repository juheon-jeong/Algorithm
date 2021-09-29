import java.io.*;
import java.util.*;

public class tmpp {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Node> st = new Stack<Node>();
        String line;
        boolean correct = true;
        while ((line = br.readLine()) != null) {
            String[] input = line.split(" ");
            st.push(new Node(0, 0, 1));
            for (int i = 0; i < input.length; i++) {
                String str = input[i].trim();
                String ch = str.toLowerCase();
                if (ch.equals("")) {
                    continue;
                }
                if (ch.equals("[")) {
                    st.push(new Node(0, 0, 4));
                } else if (ch.equals("]")) {
                    if (st.peek().a != 4) {
                        correct = false;
                    } else if (st.peek().a == 4) {
                        int st1 = (st.peek().v + st.peek().m) * st.peek().a;
                        st.pop();
                        st.peek().v += st1;
                    }
                } else if (ch.equals("{")) {
                    st.push(new Node(0, 0, 3));
                } else if (ch.equals("}")) {
                    if (st.peek().a != 3) {
                        correct = false;
                    } else if (st.peek().a == 3) {
                        int st2 = (st.peek().v + st.peek().m) * st.peek().a;
                        st.pop();
                        st.peek().v += st2;
                    }
                } else if (ch.equals("(")) {
                    st.push(new Node(0, 0, 2));
                } else if (ch.equals(")")) {
                    if (st.peek().a != 2) {
                        correct = false;
                    } else if (st.peek().a == 2) {
                        int st3 = (st.peek().v + st.peek().m) * st.peek().a;
                        st.pop();
                        st.peek().v += st3;
                    }
                } else {
                    if (!st.peek().map.containsKey(ch)) {
                        if (st.peek().m == 0) {
                            st.peek().m = 1;
                        }
                        st.peek().map.put(ch, 1);
                    } else {
                        int st4 = st.peek().map.get(ch) + 1;
                        st.peek().map.put(ch, st4);
                        st.peek().m = Math.max(st.peek().m, st4);
                    }
                }
            }
        }
        br.close();
        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }
        if (st.peek().a != 1) {
            correct = false;
        }
        if (correct) {
            out.println(st.peek().m + st.peek().v);

        } else {
            out.println(-1);
        }
    }
}

class Node {
    Map<String, Integer> map = new HashMap<String, Integer>();
    int v;
    int m;
    int a;

    public Node(int v, int m, int a) {
        this.v = v;
        this.m = m;
        this.a = a;
    }
}