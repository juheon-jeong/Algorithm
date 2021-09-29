package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJJ_2343 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] firstLine = br.readLine().split(" ");

        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        int [] lesson = new int [n];
        int right = 0;
        int left = 0;
        String[] secondLine = br.readLine().split(" ");
        for(int i =0; i < n; i++){
            lesson[i] = Integer.parseInt(secondLine[i]);
            right += lesson[i];
            left = left < lesson[i] ? lesson[i] : left;
        }



        while(left <= right){
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 0;
            for(int i = 0; i < n; i++){
                if(sum + lesson[i] > mid){
                    sum = 0;
                    count++;
                }
                sum += lesson[i];
            }
            if(sum != 0) {
                count++;
            }
            if(count <= m) {
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(right + 1);

        br.close();

    }
}
