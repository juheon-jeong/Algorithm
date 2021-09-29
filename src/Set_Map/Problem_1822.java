package Set_Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Problem_1822 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] first =  br.readLine().split(" ");
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new TreeSet<>();


        String[] second = br.readLine().split(" ");
        String[] third = br.readLine().split(" ");

        for(int i = 0; i < Integer.parseInt(first[0]); i++) {
            set1.add(Integer.parseInt(second[i]));
        }

        for(int i = 0; i < Integer.parseInt(first[1]); i++) {
            set2.add(Integer.parseInt(third[i]));
        }

        set1.removeAll(set2);


        System.out.println(set1.size());

        for(int v : set1) {
            System.out.print(v + " ");
        }




    }
}
