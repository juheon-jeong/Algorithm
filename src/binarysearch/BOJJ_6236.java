package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJJ_6236 {
    static int [] array;

    public static void main(String [] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] firstline = br.readLine().split(" ");
        int n = Integer.parseInt(firstline[0]);
        int m = Integer.parseInt(firstline[1]);

        array  = new int[n];

        for(int i = 0; i < n; i++){//금액저장
            array[i] = Integer.parseInt(br.readLine());

        }

        int left = 1;
        int right = 10000 * n;

        while(left <= right) {
            int mid = (left + right) / 2;
            int result = isPossiblePay(mid, n, m);

            if(result == -1) {  //인출한 돈으로 지출 불가
                left = mid + 1;
            }

            if(result == 0) { //count > m 인 경우
                left = mid + 1;
            }else if(result == 2 || result == 1) { // count <= m  인 경우
                right = mid - 1;
            }

        }
        System.out.println(left);

    }
    static int isPossiblePay(int withdraw, int n, int m) {
        int nowMoney = 0;
        int count = 0;

        for(int i = 0; i < n; i++){
            if(withdraw < array[i]){  //인출보다 지출이 큰 경우
                return -1;
            }

            if(nowMoney < array[i]){
                count++;
                nowMoney = withdraw;
                if(count > m){
                    return 0;
                }
            }
            nowMoney -= array[i];
        }
        return  count == m ? 1 : 2;
    }
}
