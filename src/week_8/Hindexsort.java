package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hindexsort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            String line = br. readLine();
            String[] IntStr = line.trim().split("\\s+");

            int result = Integer.MIN_VALUE;
            int temp_hindex = 0;

            int input[] = new int[IntStr.length];
            for(int i = 0; i < IntStr.length; i++) {
                input[i] = Integer.parseInt(IntStr[i]);
            }
            Arrays.sort(input);

            for(int i = 0; i < input.length; i++) {
                temp_hindex = Math.min(input[i], input.length - i);
                result = Math.max(result, temp_hindex);
            }
            System.out.println(result);

        }
    }
}
