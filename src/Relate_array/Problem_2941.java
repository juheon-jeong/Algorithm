package Relate_array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_2941 {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String [] k = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(String x : k) {
            s = s.replaceAll(x, "*");
        }
        System.out.println(s.length());


    }
}
