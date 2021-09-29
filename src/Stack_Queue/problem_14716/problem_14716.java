package Stack_Queue.problem_14716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class problem_14716 {
    static String [] line = null;
    static int[] dx = {0, 0, -1, -1, -1, 1, 1, 1};
    static int[] dy = {-1, 1, -1, 0, 1, -1, 0 ,1};
    static int M, N;
    static Queue<Cell> queue = new LinkedList<>();
    static int [][] test;
    static boolean [][] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstline = br.readLine().split(" ");
        M = Integer.parseInt(firstline[0]);
        N = Integer.parseInt(firstline[1]);
        int count = 0;
        test = new int[M][N];
        visit = new boolean[M][N];

        for(int i =0; i<M; i++){
            line = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                test[i][j] = Integer.parseInt(line[j]);

                }
            }

        for(int i =0; i<M; i++){
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && test[i][j] == 1) {
                    visit[i][j] = true;
                    queue.offer(new Cell(i, j));
                    bfs();
                    count ++;

                }
            }
        }

        System.out.println(count);
        }

    static void bfs() {
        while(!queue.isEmpty()){
            Cell cell = queue.poll();

            for(int i=0; i<8; i++){
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                    if(!visit[nx][ny] && test[nx][ny] == 1){
                        visit[nx][ny] = true;
                        queue.offer(new Cell(nx, ny));
                    }
                }
            }
        }
    }

    static class Cell {
        int x, y;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
