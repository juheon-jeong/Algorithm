import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class mid_4 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] sec = br.readLine().split(" ");
        int [] time = new int[sec.length];
        for(int i = 0; i < sec.length; i++) {
            time[i] = Integer.parseInt(sec[i]);
        }
        Arrays.sort(time);

        long right = time[time.length - 1] * n;
        long left = time[0];


        long mid;
        while(left <= right) {
            mid = (left + right) / 2;
            long temp;
            long sum = 0;

            for(int i = 0; i < time.length; i++) {
                temp = mid / time[i];    //명수
                sum += (temp - temp/11);
            }

            if(sum >= n){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(left);


    }
}
