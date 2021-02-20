package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1058
 */
public class BAEKJOON1058 {
    static int[][] twoFriendCount, arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 각 사람의 직접 연결된 친구를 저장하는 배열 생성
        arr = new int[N+1][N+1];

        // 각 사람의 2-친구 수를 담는 배열 생성
        twoFriendCount = new int[N+1][N+1];

        // 입력을 받아 직접친구 배열 초기화
        for(int i=1; i<=N; i++){
            String[] split = br.readLine().split("");
            for(int j=0; j<split.length; j++){
                if(split[j].equals("Y")){
                    arr[i][j+1]++;
                }
            }
        }

        for(int i=1; i<=N; i++){
            System.out.println(Arrays.toString(arr[i]));
        }

        int maxTwoFriendCnt = 0;
        for(int i=1; i<=N; i++){
            maxTwoFriendCnt = Math.max(getTwoFriend(i), maxTwoFriendCnt);
        }
        System.out.println(maxTwoFriendCnt);
    }

    static int getTwoFriend(int num){
        // 두 가지 경우를 고려해야 함
        // 1. 직접 친구인 경우 ==> count++
        // 2. 직접 친구가 아닌 경우 ==> 간접 연결된 친구 찾기 ==> Brute force!

        int count = 0;

        for(int i=1; i<=N; i++){
            if(i==num) continue; // 본인이면 PASS

            // 직접 연결된 친구이면 count++ 후  PASS
            if(arr[num][i] == 1) {
                count++;
                System.out.println(num+" 의 직접친구: "+i);
                continue;
            }

            // 직접 연결되지 않았으면 간접 연결된 친구 있는지 확인
            for(int j=1; j<=N; j++){
                if(j==num) continue; // 본인이면 PASS
                if(j==i) continue; // 직접 연결된 친구가 아니므로 PASS

                // 간접 연결된 친구이면 count++ 후 PASS
                if(arr[j][i] == 1 && arr[j][num] == 1){
                    System.out.println(num+" 과 "+ i +"의 간접친구: "+j);
                    count++;
                    break;
                }
            }
        }
        System.out.println("\t"+num+" 의 2-친구 수: " + count);
        return count;
    }
}
/*
7
NNYNNYY
NNNYNYN
YNNNYNN
NYNNNNY
NNYNNNN
YYNNNNN
YNNYNNN
 */