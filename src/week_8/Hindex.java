package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hindex {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            String line = br. readLine();
            String[] IntStr = line.trim().split("\\s+");

            int result = Integer.MIN_VALUE;
            int count = 0;
            int temp_hindex = 0;

            int input[] = new int[IntStr.length];
            for(int i = 0; i < IntStr.length; i++) {
                input[i] = Integer.parseInt(IntStr[i]);
            }

            for(int i = 0; i < input.length; i++) {
                count = 0;
                temp_hindex = input[i];

                for(int j = 0; j < input.length; j++) {
                    if(temp_hindex <= input[j]){
                        count++;
                    }
                }

                temp_hindex = Math.min(temp_hindex, count);
                result = Math.max(result, temp_hindex);
            }
            System.out.println(result);
        }
    }
}
