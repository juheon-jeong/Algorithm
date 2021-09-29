package Set_Map;

import java.io.*;
import java.util.*;

public class Solution_park {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }


        String most = "";
        String str = "";
        Map<String, Integer> hs = new HashMap<>();
        int max = 0;
        int count = 0;
        while ((str = br.readLine()) != null) {
            String[] str1 = str.split(" ");

            for (int i = 0; i < str1.length; i++) {
                if(str1.equals("")){
                    continue;
                }
                String temp = str1[i].toLowerCase();
                if (!hs.containsKey(temp)) {
                    hs.put(temp, 1);
                } else {
                    int temp_int = hs.get(temp);
                    hs.put(temp, temp_int + 1);
                    if (temp_int + 1 > max) {
                        max = temp_int + 1;
                        most = temp;
                    }
                }
                count++;
            }
        }
        double result = (double) max / count;
        double ban = Math.round(result * 100) / 100.0;

        out.println(most + " " + ban);
    }
}