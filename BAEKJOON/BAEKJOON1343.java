package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1343
 */
public class BAEKJOON1343 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] board = br.readLine().split("");

        boolean exit = false;

        int length = 0;
        for(int i=0; i<board.length; i++){
            if(board[i].equals("X")){
                length++;
            }else{
                if(length%2 == 1) {
                    exit = true;
                    break;
                }
                fill(length);
                length = 0;
                sb.append(".");
            }
        }

        if(length%2 == 1) {
            exit = true;
        }else{
            fill(length);
        }

        System.out.println(exit ? -1 : sb);
    }

    static void fill(int length){
        int mok = length/4;
        int mod = length%4;

        for(int j=0; j<mok; j++) sb.append("AAAA");
        if(mod != 0) sb.append("BB");
    }
}
