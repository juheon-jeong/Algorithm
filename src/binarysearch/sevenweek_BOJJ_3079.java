package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sevenweek_BOJJ_3079 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCount  = Integer.parseInt(br.readLine());
        int result[] = new int[TestCount];
        int ServerCount = 0;

        for(int i = 0; i < TestCount; i++){
            String[] readInputString = br.readLine().split(" ");
            ServerCount = readInputString.length;
            int serverTime[]  = new int[ServerCount];
            int userCount = Integer.parseInt(br.readLine());
            for(int j = 0; j < ServerCount; j++){
                serverTime[j] = Integer.parseInt(readInputString[j]);
            }
            Arrays.sort(serverTime);
            result[i] = BinarySearch(serverTime, userCount, serverTime[ServerCount -1]);
            System.out.println(result[i]);
        }
    }
    static int BinarySearch(int[] serverTime, int n, int max){
        int left = 1, right = max*n;
        int middle = 0;
        int result = Integer.MAX_VALUE;

        while(left <= right) {
            middle = (left + right) / 2 ;
            if(canPass(serverTime, n, middle)){
                result = result > middle ? middle: result;
                right = middle -1;
            }
            else{
                left = middle + 1 ;
            }
        }
        return result;
    }
    static boolean canPass(int[] serverTime, int n, int middle){
        int passUserCount = 0;
        for(int i = 0; i < serverTime.length; i++){
            passUserCount += middle / serverTime[i];
        }
        if(passUserCount >= n) {
            return true;
        }
        else{
            return false;
        }

    }
}
