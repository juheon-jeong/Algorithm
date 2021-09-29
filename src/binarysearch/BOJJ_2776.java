package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJJ_2776 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcase; i++) {
            int num1 = Integer.parseInt(br.readLine());
            HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
            String [] element = br.readLine().split(" ");
            for(int j = 0; j < num1; j++){
                map.put(Integer.parseInt(element[j]),true);
            }
            int num2 = Integer.parseInt(br.readLine());
            String [] element2 = br.readLine().split(" ");
            for(int j = 0; j < num2; j++){
                if(map.containsKey(Integer.parseInt(element2[j]))){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }

        }
        br.close();


    }
}
