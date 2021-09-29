package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJJ_2805 {
    static long [] trees;
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int numtree = Integer.parseInt(firstLine[0]);
        int needHeight = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        trees = new long[numtree];

        for(int i = 0; i < numtree; i++){
            trees[i] = Long.parseLong(secondLine[i]);
        }

        Arrays.sort(trees);

        long left = 1;
        long right = trees[trees.length-1];

        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i < numtree; i++){
                if(trees[i] >= mid){
                    sum += (trees[i] - mid);
                }
            }

            if(sum >= needHeight){
                left = mid + 1;
            }
            else if(sum < needHeight){
                right = mid - 1;
            }

        }


        System.out.println(left -1);


        br.close();

    }
}
