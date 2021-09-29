package Set_Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import java.util.Map;

public class voca_calc {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> voca = new HashMap<>();
        int max = 0;
        int line = Integer.parseInt(br.readLine());
        for (int i = 0; i < line; i++){
            String [] first = br.readLine().split(" ");
            for(int j = 0; j< first.length; j++){
                if(!voca.containsKey(first[j])){
                    voca.put(first[j], 1);
                }
                else{
                    int temp = voca.get(first[j]);
                    voca.put(first[j], temp+1);
                    max = Math.max(voca.get(first[j]), max);
                }

            }
        }

        System.out.println(max);
    }
}
