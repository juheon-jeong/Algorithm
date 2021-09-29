package Set_Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class voca_calc2 {
    public static void main(String [] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "" ;
        Map<String, Integer> voca = new HashMap<>();
        int max = 0;

        while((input = br.readLine()) != null) {
            String[] sentence = input.split(" ");
            for(int i = 0; i < sentence.length; i++) {
                if(!voca.containsKey(sentence[i])){
                    voca.put(sentence[i], 1);
                }
                else{
                    int temp = voca.get(sentence[i]);
                    voca.put(sentence[i], temp+1);
                    max = Math.max(max,voca.get(sentence[i]));
                }
            }
        }

        System.out.println(max);
    }
}
