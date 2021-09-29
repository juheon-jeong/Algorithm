package binarysearch;

import java.io.*;
import java.util.HashMap;

public class BOJJ_2776_2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        int n, m;

        for(int i = 0; i < test; i++) {

            n = Integer.parseInt(br.readLine());
            HashMap<Integer,Integer> noteMap = new HashMap<>();

            String [] element = br.readLine().split(" ");

            for(int j = 0; j < n; j++){
                int num = Integer.parseInt(element[j]);
                if(!noteMap.containsKey(num)){
                    noteMap.put(num, 1);
                }
            }

            m = Integer.parseInt(br.readLine());
            String [] element1 = br.readLine().split(" ");

            for(int j = 0; j < m; j++){
                int e = Integer.parseInt(element1[j]);
                if(noteMap.containsKey(e)){
                    bw.write("1\n");
                }
                else{
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

}
