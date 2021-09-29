package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Problem_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int time[][] = new int[tc][2];

        for(int i = 0; i < tc; i++) {
            String [] list = br.readLine().split("\\s+");

            time[i][0] = Integer.parseInt(list[0]);  //시작 시간
            time[i][1] = Integer.parseInt(list[1]);  //끝나는 시간

        }
        Comparator <int []> Mycomparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        };
        Arrays.sort(time, Mycomparator);

        int count = 0;
        int end_time = 0;
        for(int i = 0; i < tc; i++) {
            if(end_time <= time[i][0]) {
                end_time = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }

}
