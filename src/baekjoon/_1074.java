package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1074

문제
한수는 2차원 배열 (항상 2^N * 2^N 크기이다)을 Z모양으로 탐색하려고 한다.
예를 들어, 2*2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.

만약, 2차원 배열의 크기가 2^N * 2^N라서 왼쪽 위에 있는 칸이 하나가 아니라면, 배열을 4등분 한 후에 (크기가 같은 2^(N-1)로) 재귀적으로 순서대로 방문한다.

다음 예는 2^2 * 2^2 크기의 배열을 방문한 순서이다.

N이 주어졌을 때, (r, c)를 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

다음 그림은 N=3일 때의 예이다.

입력
첫째 줄에 N r c가 주어진다. N은 15보다 작거나 같은 자연수이고, r과 c는 0보다 크거나 같고, 2^N-1보다 작거나 같은 정수이다

출력
첫째 줄에 문제의 정답을 출력한다.
 */
public class _1074 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        recursive(r, c, n);
        System.out.println(count);
    }
    public static void recursive(int r, int c, int n){

        System.out.println(r+" "+c+" "+n);
        if(n==1){
            if(r==0&& c==0){
                count += 0;
            }else if(r==1 && c==1){
                count += 3;
            }else if(r==1 && c==0){
                count += 2;
            }else{
                count += 1;
            }
            return;
        }

        int temp = (int) ((Math.pow(2,n)-1)/2)+1;
        int temp2 = (int) (Math.pow(2,n-1) * Math.pow(2,n-1));
        System.out.println(temp+" "+temp2);
        if(r>=temp && c>=temp){
            count += temp2 * 3;
            System.out.println(count);
            recursive((int) (r-Math.pow(2,n-1)), (int) (c-Math.pow(2,n-1)), n-1);
        }else if(r>=temp && c<temp){
            count += temp2 * 2;
            System.out.println(count);
            recursive((int) (r-Math.pow(2,n-1)), c, n-1);
        }else if(r<temp && c>=temp){
            count+= temp2;
            System.out.println(count);
            recursive( r, (int) (c-Math.pow(2,n-1)), n-1);
        }else {
            System.out.println(count);
            recursive( r, c, n-1);
        }
    }
}
