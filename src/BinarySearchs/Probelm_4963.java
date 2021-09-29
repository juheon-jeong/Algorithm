package BinarySearchs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Probelm_4963 {
    static int N;
    static int M;
    static int [][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, 1, 1 ,-1 ,-1};
    static int[] dy = { 0, 0, 1, -1, 1, -1 ,1 ,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[1]);
            M = Integer.parseInt(line[0]);

            if(N == 0 && M == 0){
                break;
            }
            map = new int[N][M];
            visited = new boolean[N][M];

            int count = 0;

            for(int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for(int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    static void dfs(int x, int y) {

        for(int i = 0; i < 8; i++) {
            int x_cge = x + dx[i];
            int y_cge = y + dy[i];

            if( x_cge >= 0 && y_cge >= 0 && x_cge < N && y_cge < M && map[x_cge][y_cge] == 1 && !visited[x_cge][y_cge]){
                visited[x_cge][y_cge] = true;
                dfs(x_cge, y_cge);
            }
        }
    }
}
