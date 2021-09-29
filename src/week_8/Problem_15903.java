package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_15903 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] line = br.readLine().split("\\s+");
        int size = Integer.parseInt(line[0]);
        int num = Integer.parseInt(line[1]);

        String [] sline = br.readLine().split("\\s+");

        long arr [] = new long [size];

        for(int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(sline[i]);
        }

        for(int i = 0; i < num; i++) {
            Arrays.sort(arr);
            long temp = arr[0] + arr[1];
            arr[0] = temp;
            arr[1] = temp;
        }
        long sum = 0;
        for(int i = 0; i < size; i++) {
            sum += arr[i];
        }

        System.out.println(sum);


    }
}
