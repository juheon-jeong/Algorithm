package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJJ_2776_1 {
    static int note[];
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> noteMap;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        int n, m;

        for(int i = 0; i < test; i++){
            n = Integer.parseInt(br.readLine());
            note = new int[n];  //수첩 1
            noteMap = new HashMap<>();

            String [] element = br.readLine().split(" ");

            for(int j = 0; j < n; j++){
                note[j] = Integer.parseInt(element[j]);
                if(!noteMap.containsKey(note[j])){
                    noteMap.put(note[j], 1);
                }
            }
            Arrays.sort(note);

            m = Integer.parseInt(br.readLine());
            String [] element1 = br.readLine().split(" ");

            for(int j = 0; j < m; j++){
                int e = Integer.parseInt(element1[j]);
                binarySearch(e);
            }

        }
        System.out.println(sb);

    }

    static void binarySearch(int num) {
        int left, right, mid;
        left = 0;
        right = note.length - 1;
        while(left <= right) {
            mid = (left + right) / 2 ;
            if(noteMap.containsKey(num)){
                sb.append(1 + "\n");
                return;
            }
            else if(note[mid] > num){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

        }
        sb.append(0 + "\n");
    }
}
