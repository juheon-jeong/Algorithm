package Set_Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Print_index {
    public static void main (String[] args) throws java.lang.Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int line = Integer.parseInt(br.readLine());

       HashMap<String,Integer> map = new HashMap<>();
       ArrayList <Map<String, Integer>> list = new ArrayList<>();
       StringBuilder sb = new StringBuilder();

       String s = "";
       int max = 0;

       for(int i = 0; i < line; i++) {
           Map<String,Integer> tmpmap = new HashMap<>();

           String [] sen = br.readLine().split(" ");

           for (int j = 0; j < sen.length; j++){
               String temp_word = sen[j].toLowerCase();

               if(!map.containsKey(temp_word)){
                   // map.containsKey() 메소드가 반환하는 값.
                   // 입력값이 map에 존재하는 경우 true, 아니면 false를 준다.

                   // if문에서 언제 여기에 들어올 건가.
                   // map에 존재하지 않을 떄 여기에 들어오게 할 거다.
                   //
                   map.put(temp_word, 1);
                   tmpmap.put(temp_word, 1);
               }
               else{
                   int temp = map.get(temp_word);
                   map.put(temp_word, temp + 1 );
                   tmpmap.put(temp_word, temp + 1 );

                   if(temp+1 > max) {
                       max = temp+1;
                       s = temp_word;
                   }
               }
           }
           list.add(tmpmap);
       }


       String big = s.substring(0,1).toUpperCase();
       String new_s = big + s.substring(1);


       sb.append(new_s);


       for (int i = 0; i < list.size(); i++){
           Map<String, Integer> temp = list.get(i);

           if (temp.containsKey(s)){
               sb.append(" " + (i + 1));
           }
       }
        System.out.println(sb.toString());

    }
}
