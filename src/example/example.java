package example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class example {
    static String[] tmpArr = null;
    static int M, N;
    static int[][] ex_array;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] basic_size = br.readLine().split(" ");
        M = Integer.parseInt(basic_size[0]);  //가로 x
        N = Integer.parseInt(basic_size[1]);  //세로 y

        ex_array = new int[N][M];

        for(int i=0; i<N; i++){
            tmpArr = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                ex_array[i][j] = Integer.parseInt(tmpArr[j]);

            }
        }

        bfs();
    }

    static class Cell {
        int x, y, day;

        Cell(int M, int N, int day){
            this.x = M;
            this.y = N;
            this.day = day;
        }

    }
    static void bfs(){
        int day = 0;
        Queue<Cell> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(ex_array[i][j]==1){
                    queue.offer(new Cell(i,j,0));
                }
            }
        }
        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            day = cell.day;

            for(int i=0; i<4; i++){
                int next_x = cell.x + dx[i];
                int next_y = cell.y + dy[i];

                if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < M) {
                     if(ex_array[next_x][next_y] == 0){
                         ex_array[next_x][next_y] = 1;
                         queue.offer(new Cell(next_x, next_y, day+1));
                     }
                }
            }
        }

        if(checktomato()){
            System.out.println(day);
        }else{
            System.out.println(-1);
        }
    }


    static boolean checktomato() {
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (ex_array[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;

    }
}
