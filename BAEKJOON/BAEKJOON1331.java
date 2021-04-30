package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/1331
 */
public class BAEKJOON1331 {

    static boolean[][] visit = new boolean[7][7];
    static int startRow;
    static int startCol;
    static int[] dx = new int[]{-2, -2, -1, 1, -1, 1, 2, 2};
    static int[] dy = new int[]{-1, 1, -2, -2, 2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String curPointString = br.readLine();

        int col = curPointString.charAt(0) - 'A' + 1;
        int row = curPointString.charAt(1) - '1' + 1;

        startCol = col;
        startRow = row;
        visit[startRow][startCol] = true;

        int prevRow = row;
        int prevCol = col;

        for (int i = 0; i < 35; i++) {
            curPointString = br.readLine();

            col = curPointString.charAt(0) - 'A' + 1;
            row = curPointString.charAt(1) - '1' + 1;

            if (visit[row][col]) {
                System.out.println("Invalid");
                return;
            }

            if(!check(prevRow, prevCol, row, col)){
                System.out.println("Invalid");
                return;
            }

            visit[row][col] = true;
            prevRow = row;
            prevCol = col;
        }

        for(int i=1; i<visit.length; i++){
            for(int j=1; j<visit.length; j++){
                if(!visit[i][j]){
                    System.out.println("Invalid");
                    return;
                }
            }
        }

        if(check(prevRow, prevCol, startRow, startCol)) {
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }

    }

    static boolean check(int prevRow, int prevCol, int row, int col){
        for (int j = 0; j < 8; j++) {
            int nextRow = prevRow + dx[j];
            int nextCol = prevCol + dy[j];

            if(nextRow <= 0 || nextRow >= 7 || nextCol <=0 || nextCol >=7) continue;

            if(nextRow == row && nextCol == col){
                return true;
            }
        }
        return false;
    }
}
