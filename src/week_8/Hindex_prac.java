package week_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hindex_prac {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            String [] line = br.readLine().split("\\s+");

            int input[] = new int[line.length];
            int Hindex ;
            int answer = 0;
            int result ;
            for(int j = 0; j < line.length; j++) {
                input[j] = Integer.parseInt(line[j]);
            }
            Arrays.sort(input);

            for(int j = 0; j < input.length; j++) {
                Hindex = input[i];
                result = input.length - i;

                if( result <= Hindex){
                    answer = result;
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
