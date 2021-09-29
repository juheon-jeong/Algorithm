package BinarySearchs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Problem_1260 {
    static int[][] check;
    static boolean [] checked;
    static int n ;
    static int m;
    static int start;


    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] first = br.readLine().split(" ");
        n = Integer.parseInt(first[0]);
        m = Integer.parseInt(first[1]);
        start =  Integer.parseInt(first[2]);

        check = new int[1001][1001];
        checked = new boolean[1001];

        for(int i = 0; i < m; i++) {
            String [] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            check[x][y] = check[y][x] = 1 ;
        }

        dfs(start);

        checked = new boolean[1001];
        System.out.println();

        bfs();
    }

    public static void dfs(int i){
        checked[i] = true;
        System.out.print(i + " ");

        for(int j = 1; j <= n; j++) {
            if(check[i][j] == 1 && checked[j] == false) {
                dfs(j);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        checked[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for(int j = 1; j <= n; j++) {
                if(check[temp][j] == 1 && checked[j] == false) {
                    queue.offer(j);
                    checked[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}
