package Relate_array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Problem_2577 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr  = new int[10];

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result = a * b * c;

        String str = Integer.toString(result);

        for(int i = 0; i < str.length(); i++) {
            arr[(str.charAt(i) - '0')]++;
        }

        for(int v : arr) {
            System.out.println(v);
        }



    }
}
