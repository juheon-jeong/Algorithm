package Set_Map;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.io.*;
import java.util.*;


public class Mapex {
    public static void main(String[] args) throws IOException {
        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        HashMap<String, Integer> map = new HashMap<>();

        int count = 0;
        int max = 0;
        String max_string = "";

        while((input = br.readLine()) != null) {
            String [] line = input.split(" " );
            for(int i = 0; i < line.length; i++){
                if(line[i].equals("")) {
                    continue;
                }
                String small = line[i].toLowerCase();
                if(!map.containsKey(small)){
                    map.put(small, 1);
                }
                else{
                    int temp = map.get(small);
                    map.put(small, temp + 1);
                    if(temp+1 > max) {
                        max = temp + 1;
                        max_string = small;
                    }
                }
                count++;
            }
        }


        double rate = (double) max / count;

        out.println(max_string+" "+ Math.round(rate*100)/100.0);



        //out.println("출력은 System.out 대신 이 변수를 통해서 진행");
    }
}