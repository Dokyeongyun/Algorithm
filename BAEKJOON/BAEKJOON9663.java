package BAEKJOON;

import java.util.Scanner;
// dfs
/*
문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 */
public class BAEKJOON9663 {

    public static int N;
    public static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 각 행에는 하나의 열에만 퀸이 놓여질 수 있다.
        // 1 열부터 N열까지 돌면서 각 1행 N열에 퀸을 놓았을때 가능한 경우를 확인한다.
        for(int i = 1; i <= N; i++) {
            int[] col = new int[N+1]; // N * N 행렬이기에 열도 인덱스를 N 까지 갖을 수 있게 한다.

            // 1행 i열에 퀸을 놓았다.
            col[1] = i;
            // 1행 i열에 퀸을 놓았을 경우 가능한 횟수를 dfs로 구한다.
            dfs(col, 1);
        }

        System.out.println(count);
    }
    // row 행까지는 퀸을 놓았다.
    // row+1행에 퀸을 놓을수 있는지 확인한다.
    // 만약 row 값이 N 과 같다면 N 행까지 퀸을 놓았다는 말이므로 count를 1 증가시켜준다.
    public static void dfs(int[] col, int row) {
        if(row == N) {
            count++;
        }else {
            // 1열 부터 N 열까지 반복하면서 (row+1, i)에 퀸을 놓을 수 있는경우가 있는지 확인한다.
            // 있으면 다음행의 dfs를 호출한다.
            for(int i = 1; i <= N; i++) {
                col[row+1] = i;
                if(isPossible(col, row+1)) {
                    dfs(col, row+1);
                }
            }
        }
    }

    public static boolean isPossible(int[] col, int row) {
        // 1행부터 row 행까지 같은 열 혹은 대각선에 위치하는 퀸이 있는지 확인한다.

        for(int i=1; i < row; i++) {
            // i 행과 row 행의 열 값이 같으면 퀸을 놓을수 없다.
            if(col[i] == col[row]) return false;

            // i 행과 row 행의 열값이 대각선에 위치하는 절대값이면 안된다.
            if(Math.abs(i - row) == Math.abs(col[i] - col[row])) return false;
        }
        return true;
    }
/*    static boolean[][] boardArr;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        boardArr = new boolean[N][N];

        for (int k = 0; k < N; k++) {

            for (int i = 0; i < boardArr.length; i++) {
                for (int j = 0; j < boardArr.length; j++) {
                    boardArr[i][j] = false;
                }
            }

            dfs(k, 0, 0, boardArr);
        }

        System.out.println(count);
    }

    public static void dfs(int row, int col, int num, boolean[][] boardArr) {

        System.out.println("==[ " + row + ", " + col + " ]==");
        // 종료조건
        if (num + 1 == boardArr.length) {
            count++;
            return;
        } else {
            // 1열 부터 N 열까지 반복하면서 (row+1, i)에 퀸을 놓을 수 있는경우가 있는지 확인한다.
            // 있으면 다음행의 dfs를 호출한다.
            for (int i = 0; i < boardArr.length; i++) {

            }
        }

        // boardArr[row][col] 와 같은 행, 열, 대각선의 값 모두 false

        for (int i = 0; i < boardArr.length; i++) {
            for (int j = 0; j < boardArr.length; j++) {

                // 같은 행 false
                if (i == row) {
                    boardArr[i][j] = true;
                }

                // 같은 열 false
                if (j == col) {
                    boardArr[i][j] = true;
                }

                // 대각선 false
                int n = 1;
                while (n != boardArr.length) {
                    // 좌상단
                    if (i == (row - n) && j == (col - n)) {
                        boardArr[i][j] = true;
                    } else if (i == (row - n) && j == (col + n)) {
                        boardArr[i][j] = true;
                    } else if (i == (row + n) && j == (col - n)) {
                        boardArr[i][j] = true;
                    } else if (i == (row + n) && j == (col + n)) {
                        boardArr[i][j] = true;
                    }
                    n++;
                }

            }
        }

        // 출력
        for (int i = 0; i < boardArr.length; i++) {
            for (int j = 0; j < boardArr.length; j++) {

                System.out.print(boardArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================================");


        boolean[][] tempBoard = new boolean[boardArr.length][boardArr.length];
        for(int i=0; i<boardArr.length; i++){
            for(int j=0; j<boardArr.length; j++){
                tempBoard[i][j] = boardArr[i][j];
            }
        }

        // num 다음 열 중 false 탐색 없으면 종료, 있으면 dfs
        for (int i = 0; i < boardArr.length; i++) {
            if (!boardArr[i][num + 1]) {
                dfs(i, num + 1, num + 1, boardArr);
            }
        }

    }


    */
}
