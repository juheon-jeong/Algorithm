package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJJ_2512 {

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        long [] arr = new long [size];
        long max = 0;
        long right;

        String [] slist = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < size ; i++){
            int k = Integer.parseInt(slist[i]);
            arr[i] = k;
            max = Math.max(max, arr[i]);
        }

        right = max;
        long left = 1;


        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for(int i = 0; i < size; i++) {
                if(arr[i] >= mid) {
                    sum += mid;
                }else{
                    sum += arr[i];
                }

            }

            if(sum > x) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }

        }

        System.out.println(right);
    }
}
