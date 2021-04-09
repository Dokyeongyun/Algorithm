package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1063
 */
public class BAEKJOON1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        Point kingPoint = new Point(king.charAt(0)-65,(int)king.charAt(1)-49);
        Point stonePoint = new Point(stone.charAt(0)-65, (int)stone.charAt(1)-49);

        while(N-->0){
            String command = br.readLine();

            int nextC = 0;
            int nextR = 0;
            switch (command){
                case "R":
                    nextC = 1;
                    break;
                case "L":
                    nextC = -1;
                    break;
                case "B":
                    nextR = -1;
                    break;
                case "T":
                    nextR = 1;
                    break;
                case "RT":
                    nextC = 1;
                    nextR = 1;
                    break;
                case "LT":
                    nextC = -1;
                    nextR = 1;
                    break;
                case "RB":
                    nextC = 1;
                    nextR = -1;
                    break;
                case "LB":
                    nextC = -1;
                    nextR = -1;
                    break;
            }

            if(kingPoint.c+nextC < 0 || kingPoint.c+nextC >= 8 || kingPoint.r+nextR < 0 || kingPoint.r+nextR >= 8){
                continue;
            }
            if(kingPoint.c + nextC == stonePoint.c && kingPoint.r +nextR == stonePoint.r){
                if(stonePoint.c+nextC < 0 || stonePoint.c+nextC >= 8 || stonePoint.r+nextR < 0 || stonePoint.r+nextR >= 8){
                    continue;
                }

                kingPoint.c += nextC;
                kingPoint.r += nextR;
                stonePoint.c += nextC;
                stonePoint.r += nextR;
                continue;
            }

            kingPoint.c += nextC;
            kingPoint.r += nextR;
        }

        System.out.println((char)(kingPoint.c+65)+""+(char)(kingPoint.r+49));
        System.out.println((char)(stonePoint.c+65)+""+(char)(stonePoint.r+49));
    }
    static class Point{
        int c;
        int r;
        Point(int c, int r){
            this.c = c;
            this.r = r;
        }

        @Override
        public String toString() {
            return c+" "+r;
        }
    }
}
