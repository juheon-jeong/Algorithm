package Set_Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class basic_set_problem {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Set<String>> list = new ArrayList<>();

        String [] firstline = br.readLine().split(" ");

        int group = Integer.parseInt(firstline[0]);
        int testcase = Integer.parseInt(firstline[1]);  //첫번째 줄
        for(int i = 0; i < group; i++){
            Set<String> s = new HashSet<>();
            list.add(s);
        }

        for(int i = 0; i < testcase; i++) {
            String[] save = br.readLine().split(" ");
            int group_number = Integer.parseInt(save[0]);
            list.get(group_number).add(save[1]);
        }

        int question = Integer.parseInt(br.readLine());

        for(int i = 0; i < question; i++){
            String [] q2 = br.readLine().split(" ");
            String status = q2[0];
            int first = Integer.parseInt(q2[1]);
            int second = Integer.parseInt(q2[2]);
            int third = Integer.parseInt(q2[3]);
            Set<String> temp_first = new HashSet<>();
            for(String k : list.get(first)){
                temp_first.add(k);
            }
            Set<String> temp_second = new HashSet<>();
            for(String m : list.get(second)){
                temp_second.add(m);
            }

            Set<String> temp_third = new HashSet<>();
            for(String l : list.get(third)){
                temp_third.add(l);
            }

            if(status.equals("U")){
                temp_first.addAll(temp_second);
                temp_first.addAll(temp_third);
            }
            else if(status.equals("I")){
                temp_first.retainAll(temp_second);
                temp_first.retainAll(temp_third);
            }
            else if(status.equals("D")){
                temp_first.removeAll(temp_second);
                temp_first.removeAll(temp_third);
            }

            System.out.println(temp_first.size());

        }

    }
}
