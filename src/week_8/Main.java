
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] line = br.readLine().split(" ");
        int tc = Integer.parseInt(line[0]);
        int value = Integer.parseInt(line[1]);

        int list [] = new int[tc];
        int sum = 0;

        for(int i = 0; i < tc; i++) {
            int temp = Integer.parseInt(br.readLine());
            list[i] = temp;
        }


        Arrays.sort(list);
        int max_index = list.length - 1;
        for(int i = 0; i < tc; i++) {
            if(list[i] >= value ){
                max_index = i - 1;
                break;
            }
        }

        for(int i = max_index; i >= 0; i--) {
            sum += (value / list[i]);
            value %= list[i];
        }

        System.out.println(sum);
    }
}
