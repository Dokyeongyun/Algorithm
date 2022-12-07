package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17144
 */
public class _17144 {

    static int R, C, T;
    static int[][] room;
    static Point airLocation;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp==-1) airLocation = new Point(i, j);
                room[i][j] = temp;
            }
        }

        for(int i=0; i<T; i++){
            diffusion();
            clean();
        }
        print();
    }

    // 1초동안 확산되는 작업
    static void diffusion(){
        int[][] tempRoom = new int[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(room[i][j] == 0) continue;

                tempRoom[i][j] += room[i][j];

                // 미세먼지가 있는 칸이면 상하좌우 확산
                int amount = room[i][j] / 5; // 확산되는 양
                int total = 0; // 전체 확산되는 양

                // 상하좌우로 확산될 수 있는지 체크한 후, 된다면 확산
                for(int k=0; k<4; k++){
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];

                    if(!isBoundary(nextX, nextY)) continue; // 범위 벗어남
                    if(room[nextX][nextY] == -1) continue; // 공기청정기가 흡입

                    tempRoom[nextX][nextY] += amount;
                    total += amount;
                }
                tempRoom[i][j] -= total;
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                room[i][j] = tempRoom[i][j];
            }
        }
//        print();
    }

    static void print(){
        int count = 0;
//        System.out.println("======================");
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(room[i][j]!=-1){
                    count += room[i][j];
                }
//                System.out.print(room[i][j]+" ");
            }
//            System.out.println();
        }
//        System.out.println("======================");
        System.out.println(count);
    }

    static boolean isBoundary(int x, int y){
        return x < R && x >= 0 && y < C && y >= 0;
    }

    // 1초동안 공기청정되는 작업
    static void clean(){
        int[][] tempRoom = new int[R][C];
        // 위쪽 바람 => 반시계방향으로
        for(int p=0; p<R; p++){
            for(int q=0; q<C; q++){
                if(q == 0){ // 왼쪽
                    if(p < airLocation.x-1){
                        tempRoom[p+1][q] = room[p][q];
                        continue;
                    }
                    if(p > airLocation.x+1){
                        tempRoom[p-1][q] = room[p][q];
                        continue;
                    }
                }
                if(q == C-1){ // 오른쪽
                    if(p <= airLocation.x-1 && p > 0){
                        tempRoom[p-1][q] = room[p][q];
                        continue;
                    }
                    if(p >= airLocation.x && p != R-1){
                        tempRoom[p+1][q] = room[p][q];
                        continue;
                    }
                }
                if(p == 0 && q >= 1){ // 0행
                    tempRoom[p][q-1] = room[p][q];
                    continue;
                }
                if(p == airLocation.x-1 && q > 0){ // 공기청정기 위 행
                    tempRoom[p][q+1] = room[p][q];
                    continue;
                }
                if(p == airLocation.x && q > 0){ // 공기청정기 아래 행
                    tempRoom[p][q+1] = room[p][q];
                    continue;
                }
                if(p == R-1 && q <= C-1){ // R-1행
                    tempRoom[p][q-1] = room[p][q];
                    continue;
                }
                tempRoom[p][q] = room[p][q];
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                room[i][j] = tempRoom[i][j];
            }
        }
//        print();
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x+" "+y;
        }
    }
}
