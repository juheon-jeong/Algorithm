package Set_Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem_14425 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] first = br.readLine().split(" ");

        int size1 = Integer.parseInt(first[0]);
        int size2 = Integer.parseInt(first[1]);

        Set<String> set1 = new HashSet<>();
        int result = 0;

        for(int i = 0; i < size1; i++){
            String line = br.readLine();
            set1.add(line);
        }

        for(int i = 0; i < size2; i++){
            String line = br.readLine();
            if(set1.contains(line)){
                result++;
            }
        }

        System.out.println(result);

    }
}
