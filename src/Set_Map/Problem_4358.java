package Set_Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Map;
import java.util.TreeMap;

public class Problem_4358 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        Map<String, Integer> map = new TreeMap<>();
        int count = 0;

        while((input = br.readLine()) != null){
            if(!map.containsKey(input)){
                map.put(input, 1);
            }
            else{
                int temp = map.get(input);
                map.put(input, temp+1);

            }
            count++;
        }

        for(String x : map.keySet()){
            double percent = (double) map.get(x) * 100 / count ;
            System.out.println(x + " " + String.format("%.4f",percent)); //반올림포함
        }
    }
}