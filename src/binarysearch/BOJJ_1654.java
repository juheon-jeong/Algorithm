package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJJ_1654 {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] firstLine = br.readLine().split(" ");

        int k = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);

        long [] arr_length = new long[k];
        long left = 1;
        long max = 0;
        long mid;

        for(int i = 0; i < k; i++){
            arr_length[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr_length[i]);
        }

        long right = max;


        while(left <= right){
            mid = (left + right) / 2;
            int sum = 0;
            for(int i = 0; i < k; i++){
                long temp = arr_length[i] / mid;  //각각의 요소마다 나올 수 있는 랜선의 수
                sum += temp;
            }

            if (sum >= n){
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }

        System.out.println(left-1);

    }
}
