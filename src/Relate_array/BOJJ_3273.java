package Relate_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        String [] s_test_array = br.readLine().split(" ");
        int [] test_array = new int[size];

        for(int i=0; i<size; i++){
            test_array[i] = Integer.parseInt(s_test_array[i]);
        }
        Arrays.sort(test_array);

        int multi = Integer.parseInt(br.readLine());

        int start = 0;
        int end = size-1;
        int count = 0;


        while(start < end) {
            int sum = test_array[start] + test_array[end];
            if(sum == multi){
                count++;
            }
            if(sum <= multi){
                start++;
            }else end--;
        }
        System.out.println(count);


    }
}
