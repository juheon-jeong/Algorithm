package Set_Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Print_index2 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        Map<String,Integer> map = new HashMap<>();
        ArrayList<Map<String,Integer>> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        String s = "";
        int max = 0;

        while((input = br.readLine()) != null){
            Map<String,Integer> tmpmap = new HashMap<>();

            String [] sen = input.split(" ");

            for(int i = 0; i < sen.length; i++){
                String temp_word = sen[i].toLowerCase();

                if(!map.containsKey(temp_word)){
                    map.put(temp_word,1);
                    tmpmap.put(temp_word,1);
                }
                else{
                    int temp = map.get(temp_word);
                    map.put(temp_word, temp + 1);
                    tmpmap.put(temp_word, temp + 1);

                    if(temp+1 > max) {
                        max = temp + 1;
                        s = temp_word;
                    }
                }
            }
            list.add(tmpmap);

        }
        sb.append(s);

        for(int i = 0; i < list.size(); i++){
            Map<String,Integer> check = list.get(i);

            if(check.containsKey(s)){
                sb.append(" " + (i + 1));
            }
        }
        System.out.println(sb.toString());
    }
}
