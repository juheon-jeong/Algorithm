package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Week6_exam_Celldivide {
    static String[] tempArr = null;
    static int W,H;
    static int[][] ex_array;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] basic_size = br.readLine().split(" ");
        W = Integer.parseInt((basic_size[0])); //가로
        H = Integer.parseInt(basic_size[1]); // 세로

        ex_array = new int [H][W];

        for(int i = 0; i< H; i++){
            tempArr = br.readLine().split(" ");
            for(int j = 0; j < W; j++){
                ex_array[i][j] = Integer.parseInt(tempArr[j]);
            }
        }
        bfs();

    }

    static class Cell {
        int x, y, day;

        Cell(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static void bfs() {
        int day = 0;
        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(ex_array[i][j] == 0){
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

                if(next_x >= 0 && next_x < H && next_y >= 0 && next_y < W){
                    if(ex_array[next_x][next_y] > 0){
                        queue.offer(new Cell(next_x, next_y, day+ex_array[next_x][next_y]));
                        ex_array[next_x][next_y] = 0;
                    }
                }
            }
        }

        if(checkcell()){
            System.out.println(day);
        }else{
            System.out.println(-1);
        }
    }
    static boolean checkcell() {
        for(int i = 0; i < H; i++){
            for( int j = 0; j < W; j++){
                if(ex_array[i][j] > 0){
                    return false;
                }
            }
        }

        return true;
    }
}
