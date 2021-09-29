package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class group {
    int state, velo;
    double time;

    public group(int state, int velo, double time) {
        this.state = state;
        this.velo = velo;
        this.time = time;
    }
}
public class third_problem {
    public static void main(String  [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] line = br.readLine().split(" ");
        int num = Integer.parseInt(line[0]);
        int distance = Integer.parseInt(line[1]);
        int count = 0;
        ArrayList<group> list = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            String [] info = br.readLine().split(" ");
            int state = Integer.parseInt(info[0]);
            int velo = Integer.parseInt(info[1]);
            int temp = distance - state;
            double time = temp / velo;
            list.add(new group(state, velo, time));
        }

        Comparator<group> My = new Comparator<group>() {
            @Override
            public int compare(group o1, group o2) {
                return o1.state - o2.state;
            }
        };

        Collections.sort(list, My);
        Set<Integer> index_set = new HashSet<>();

        for(int i = 0; i < list.size(); i++) {
            if(index_set.contains(i)){
                continue;
            }else{
                for(int j = i+1 ; j < list.size(); j++) {
                    if(list.get(i).time <= list.get(j).time){
                        index_set.add(j);
                    }

                }
                count++;
            }

        }

        System.out.println(count);
    }
}
