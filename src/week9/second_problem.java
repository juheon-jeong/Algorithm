package week9;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class invest {
    String name;
    int score;

    public invest (String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class second_problem {
    public static void main(String [] args) throws IOException{
        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        ArrayList<invest> mainlist = new ArrayList<>();

        while((input = br.readLine()) != null) {
            String [] line = input.split(" ");
            String name = line[0];
            ArrayList<Integer> temp = new ArrayList<>();
            int temp_index = 0;
            int result = Integer.MIN_VALUE;
            for(int i = 1; i < line.length; i++) {
                temp.add(Integer.parseInt(line[i]));
            }
            Collections.sort(temp);
            for(int i = 0; i < temp.size(); i++) {
                temp_index = Math.min(temp.get(i), temp.size() - i);
                result = Math.max(result, temp_index);
            }
            mainlist.add(new invest(name, result));
        }
        Comparator <invest> My = new Comparator<invest>() {
            @Override
            public int compare(invest o1, invest o2) {
                return o2.score - o1.score;
            }
        };

        Collections.sort(mainlist, My);

        out.println(mainlist.get(0).name + " " + mainlist.get(0).score);


    }
}
