package Set_Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJJ_19583 {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] firstLine = br.readLine().split(" ");
        String S = firstLine[0];
        String E = firstLine[1];
        String Q = firstLine[2];

        HashSet<String> before = new HashSet<>();
        HashSet<String> after = new HashSet<>();
        HashSet<String> nameset = new HashSet<>();

        String str = "";


        while((str = br.readLine()) != null){
            String[] line = str.split(" ");
            String time = line[0];
            String name = line[1];

            nameset.add(name);

            if(S.compareTo(time) >= 0){
                before.add(name);
            }
            else if(E.compareTo(time) <= 0 && Q.compareTo(time) >= 0){
                after.add(name);
            }

        }

        int answer = 0;

        for(String name : nameset){
            if(before.contains(name) && after.contains(name)){
                answer++;
            }
        }

        System.out.println(answer);



    }
}
