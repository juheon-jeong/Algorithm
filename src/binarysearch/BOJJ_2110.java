package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJJ_2110 {
    public static void main(String [] args) throws  Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] firstLine = br.readLine().split(" ");

        int n = Integer.parseInt(firstLine[0]);
        int c = Integer.parseInt(firstLine[1]);

        int[] houses = new int[n];


        for( int i = 0; i < n; i++){
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int left = 1;
        int right = houses[n-1] - houses[0];
        int mid;

        while(left <= right){
            int count = 1;
            int prev = houses[0];
            mid = (left + right) / 2;

            for(int house : houses){
                if(house - prev >= mid){
                    count++;
                    prev = house;
                }
            }

            if(count >= c) {
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(left-1);

    }
}
