package Dev_day;

import java.io.*;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class practice {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gcd;

        /*int female = Integer.parseInt(line[0]);
        int male = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);

        int max = female/2 < male ? female/2 : male ; // 팀 수
        k -= female - 3*max + male ;

        while(k > 0) {
            k -= 3;
            max--;
        }

        System.out.println(max);
*/
        while(true) {
            String [] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            if(x == 0 && y == 0){
                break;
            }
            else{
                gcd = get_gcd(x, y);
                System.out.println(gcd);

            }
        }
    }
    public static int get_gcd(int x, int y){
        int r;
        while( y != 0) {
            r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

}
