package Relate_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJJ_15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] firstline = br.readLine().split(" ");

        int size = Integer.parseInt(firstline[0]);
        int k = Integer.parseInt(firstline[1]);

        String [] secondline = br.readLine().split(" ");

        int [] doll = new int[size];

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<size; i++){
            doll[i] = Integer.parseInt(secondline[i]);

            if(doll[i] == 1){
                list.add(i);
            }
        }
        if(list.size() < k){
            System.out.println(-1);
        }

        int distance = Integer.MAX_VALUE;

        for(int start =0; start<list.size(); start++){
            int end = start;
            int temp =0;
            while(end<list.size() && temp<k){
                temp++;
                end++;
            }

            if(temp == k){
                int left = list.get(start);
                int right = list.get(end-1);
                distance = Math.min(distance,right-left+1);

            }
        }
        System.out.println(distance);


    }
}
