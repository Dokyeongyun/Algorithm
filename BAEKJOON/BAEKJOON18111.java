package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON18111 {
    static int[][] houseSite;
    static int N, M, B, maxNum, minNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        houseSite = new int[N][M];

        maxNum = 0;
        minNum = 256;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int temp = Integer.parseInt(st.nextToken());
                houseSite[i][j] = temp;
                minNum = Math.min(minNum, temp);
                maxNum = Math.max(maxNum, temp);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;

        int temp = 0;
        for(int i=minNum; i<=maxNum; i++){
            temp = getTime(i);
            if(temp == -1) {
                continue;
            }
            if(minTime >= temp){
                minTime = temp;
                height = i;
            }
        }
        System.out.println(minTime +" "+height);
    }

    static int getTime(int height) {
        int time = 0;
        int inventory = B;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (houseSite[i][j] < height) {
                    inventory -= (height - houseSite[i][j]);
                    time += (height - houseSite[i][j]);
                }
                else if (houseSite[i][j] > height) {
                    inventory += (houseSite[i][j] - height);
                    time += (houseSite[i][j] - height)*2;
                }
            }
        }
        if (inventory < 0) {
            return -1;
        }
        return time;
    }
}
