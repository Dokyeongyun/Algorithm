package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1117
 */
public class _1117 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H][W];

        for(int i=0; i<arr.length; i++){
            Arrays.fill(arr[i], 1);
        }
        // x=f 로 접기
        // f-1칸 + f칸, f-2칸 + f+1칸 ===> f<0 break;
        int newXStart = f;

        int temp = f-1;
        for(int j=f; j<W; j++){
            if(temp<0) break;
            for(int i=0; i<H; i++){
                arr[i][j] = arr[i][temp] + arr[i][j];
            }
            temp--;
        }

        // y축을 c+1 등분하기
        int eq = H/(c+1);
        int temp3 = H/(c+1);
        int cTemp = c;
        while(c-->0){
            int temp2 = newXStart-1;
            for(int j=newXStart; j<H; j++){
                if(temp2<0) break;
                for(int i=eq; i<W; i++){
                    arr[j][i] = arr[temp2][i] + arr[j][i];
                }
                temp2--;
            }
            newXStart += temp3;
        }

        int xIndex = f;
        int yIndex = H/(cTemp+1) * cTemp;

        int sum = 0;
        for(int j=yIndex+x1-1; j<yIndex+x2-x1-1; j++){
            for(int i=xIndex+y1; i<=xIndex+y2; i++){
                sum += arr[j][i];
            }
        }

        System.out.println(W*H - sum);
    }
}
