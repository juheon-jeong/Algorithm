package Relate_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJJ_2003 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] firstline = br.readLine().split(" ");
        int size = Integer.parseInt(firstline[0]);
        int multi = Integer.parseInt(firstline[1]);

        int [] test_array = new int[size+1];

        String [] secondline = br.readLine().split(" ");

        for(int i=0; i<size; i++) {
            test_array[i] = Integer.parseInt(secondline[i]);
        }// 배열에 모든 원소 저장

        int start = 0;//index
        int end = 0;//index
        int part = 0;//부분합
        int count = 0; //경우의 수 카운트

        while(end < size) {
            if(part >= multi){
                part -= test_array[start];
                start++;
            }
            else{
                part += test_array[end];
                end++;
            }
            if(part == multi){
                count++;
            }
        }
        System.out.println(count);

    }
}
