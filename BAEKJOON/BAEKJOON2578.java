package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2578
 */
public class BAEKJOON2578 {
    static int[][] bingo = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> call = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                call.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < call.size(); i++) {
            int temp = call.get(i);
            marking(temp);

            int bingoCount = 0;
            bingoCount += rowCheck();
            bingoCount += colCheck();
            bingoCount += diagonalCheck();

            if(bingoCount >= 3 ){
                System.out.println(i+1);
                break;
            }
        }

    }

    static void marking(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == number) bingo[i][j] = 0;
            }
        }
    }

    static int rowCheck() {
        int rowBingoCount = 0;
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 0) count++;
            }
            if (count == 5) rowBingoCount++;
        }
        return rowBingoCount;
    }

    static int colCheck() {
        int colBingoCount = 0;
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == 0) count++;
            }
            if (count == 5) colBingoCount++;
        }
        return colBingoCount;
    }

    static int diagonalCheck() {
        int diagonalBingoCount = 0;

        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0) count++;
        }
        if (count == 5) diagonalBingoCount++;

        count = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] == 0) count++;
        }
        if (count == 5) diagonalBingoCount++;

        return diagonalBingoCount;
    }
}
