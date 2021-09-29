package Stack_Queue.problem_7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class problem_7569 {
    //
    static String [] input_tomato = null;
    static int [][][] box;
    static int H, M, N;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};


    static class Cell{
        int x, y, z, day;

        public Cell(int x, int y, int z, int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    public static void main(String [] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] size = br.readLine().split(" ");
        M = Integer.parseInt(size[0]);   //가로
        N = Integer.parseInt(size[1]);   //세로
        H = Integer.parseInt(size[2]);   //높이
        box = new int[H][N][M];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                input_tomato = br.readLine().split(" ");
                for(int k = 0; k < M; k++){
                    box[i][j][k] = Integer.parseInt(input_tomato[k]);
                }
            }
        }
        if(checktomato()){
            System.out.println(0);
        }else{
            bfs();
        }


    }
    static void bfs() {
        int day = 0;
        Queue<Cell> queue = new LinkedList<Cell>();

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(box[i][j][k] == 1){
                        queue.offer(new Cell(k, j, i, 0 ));
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            day = cell.day;
            for(int i=0; i<6; i++) {
               int next_x = cell.x + dx[i];
               int next_y = cell.y + dy[i];
               int next_z = cell.z + dz[i];

                if (next_x >= 0 && next_x <  M && next_y >= 0 && next_y < N && next_z >= 0 && next_z < H) {
                    if (box[next_z][next_y][next_x] == 0) {
                        box[next_z][next_y][next_x] = 1;
                        queue.offer(new Cell(next_x, next_y, next_z, day + 1));
                    }
                }
            }

        }

        if(checktomato()) {
            System.out.println(day);
        }
        else{
            System.out.println(-1);
        }



    }
    static boolean checktomato() {
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(box[i][j][k] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
