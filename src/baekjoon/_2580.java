package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2580
 */
public class _2580 {

    static int[][] sudoku;
    static List<Point> emptyList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int temp = Integer.parseInt(st.nextToken());
                sudoku[i][j] = temp;
                if (temp == 0) emptyList.add(new Point(i, j));
            }
        }

        backtracking(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for(int j=0; j<9; j++){
                sb.append(sudoku[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static boolean backtracking(int count) {
        if (count == emptyList.size()) {
            return true;
        }

        Point emptyPoint = emptyList.get(count);
        int x = emptyPoint.x;
        int y = emptyPoint.y;

        for (int i = 1; i < 10; i++) {
            if (check(sudoku, x, y, i)) {
                sudoku[x][y] = i;
                if (backtracking(count + 1)) return true;
                sudoku[x][y] = 0;
            }
        }

        return false;
    }

    static boolean check(int[][] arr, int x, int y, int num) {
        int blockX = x / 3;
        int blockY = y / 3;

        // 행, 열 확인
        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == num) return false;
            if (arr[i][y] == num) return false;
        }

        // 3X3 블록 확인
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[(blockX * 3) + i][(blockY * 3) + j] == num)
                    return false;
            }
        }

        return true;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
