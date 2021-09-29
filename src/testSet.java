

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class testSet {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] first = br.readLine().split(" ");
        String [] second = br.readLine().split(" ");

        Set<Integer> first_set = new TreeSet<Integer>();
        Set<Integer> second_set = new TreeSet<>();


        for(int i = 0; i < first.length; i++) {
            int k = Integer.parseInt(first[i]);
            first_set.add(k);
        }

        for(int i = 0; i < second.length; i++) {
            int k = Integer.parseInt(second[i]);
            second_set.add(k);
        }


        String answer = br.readLine();

        if(answer.equals("U")){
            first_set.addAll(second_set);
        }
        else if(answer.equals("I")){
            first_set.retainAll(second_set);
        }else{
            first_set.removeAll(second_set);
        }

        for(Integer k: first_set){
            System.out.print(k + " ");
        }
    }


}
