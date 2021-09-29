package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_9237 {

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        ArrayList <Integer> arr = new ArrayList<>();
        ArrayList <Integer> arr2 = new ArrayList<>();
        String [] temp = br.readLine().split(" ");

        for(int i = 0; i < first; i++) {
            arr.add(Integer.parseInt(temp[i]));
        }

        Collections.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < arr.size(); i++) {
            int index = i + 1;
            int result = arr.get(i) + index + 1;
            arr2.add(result);
        }
        int tp = arr2.get(0);

        for(int i = 1; i < arr2.size(); i++) {
            tp = Math.max(tp, arr2.get(i));
        }

        System.out.println(tp);




    }
}
