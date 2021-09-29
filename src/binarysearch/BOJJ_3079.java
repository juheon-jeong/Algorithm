package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJJ_3079 {
    static int[] array;
    static long maxHigh = 0;
    static long min = Long.MAX_VALUE;
    public static void main(String [] args) throws  Exception {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        String [] firstline = br.readLine().split(" ");

        int N = Integer.parseInt(firstline[0]);
        long M = Long.parseLong(firstline[1]);

        array = new int[N];

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(br.readLine());
            maxHigh = Math.max(maxHigh, array[i]);
        }

        BinarySearch(N, M);
        System.out.println(min);





    }
    static void BinarySearch(int n, long m){
        long left = 0;
        long right = maxHigh * m;

        while(left <= right){
            long middle = (left + right) / 2;
            long sum = 0;

            for(int element : array){
                long count = middle / element;  //해당 시간동안의 사람 수
                sum += count;
            }

            if(sum >= m){
                min = Math.min(min, middle);
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }

        }
    }
}
