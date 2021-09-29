package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class score {
    int day, se;
    public score(int day, int se) {
        this.day = day;
        this.se = se;
    }
}

public class Problem_13904 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        ArrayList<score> list = new ArrayList<>();

        for(int i = 0; i < tc; i++) {
            String [] line = br.readLine().split("\\s+");
            int temp_day = Integer.parseInt(line[0]);
            int temp_score = Integer.parseInt(line[1]);
            list.add(new score(temp_day, temp_score));
        }
        Comparator<score> Mycomparator = new Comparator<score>() {
            @Override
            public int compare(score o1, score o2) {
                return o2.se - o1.se;
            }
        };
        Collections.sort(list, Mycomparator);

        int result[] = new int[1000];
        int sum = 0;
        for (int i = 0; i < tc; i++) {
            score now = list.remove(0);

            for(int j = now.day - 1; j >= 0; j--) {

                if (result[j] == 0) {
                    result[j] = now.se;
                    sum += result[j];
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}
