package BinarySearchs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2263 {

    static int n;
    static int[] in, post, pre;
    static int index;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        in = new int[n];
        post = new int[n];
        pre = new int[n];

        String [] line = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(line[i]);
        }

        line = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(line[i]);
        }

        PreOrder(0, n-1, 0, n-1);

        for(int print : pre){
            System.out.print(print + " ");
        }
    }

    public static void PreOrder(int in_start, int in_end, int post_start, int post_end){
        if(in_start <= in_end && post_start <= post_end){
            pre[index] = post[post_end];
            index++;

            int temp = in_start;

            for(int i = in_start; i  <= in_end; i++) {
                if(in[i] == post[post_end]){
                    temp = i;
                    break;
                }
            }
            //왼쪽
            PreOrder(in_start, temp -1, post_start, post_start + temp - in_start -1 );
            //오른쪽
            PreOrder(temp + 1, in_end, post_start + temp - in_start, post_end -1);
        }
    }
}
