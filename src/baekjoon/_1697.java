package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
문제
수빈이는 동생과 숨바꼭질을 하고 있다.
수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
수빈이는 걷거나 순간이동을 할 수 있다.
만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 */
public class _1697 {

    static int n, k;
    static int[] check = new int[100001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();

        dfs();
    }

    public static void dfs() {
        Queue<Integer> que = new LinkedList<>();

        que.add(n);
        check[n] = 1;

        while (!que.isEmpty()) {
            int current = que.poll();

            for (int i = 0; i < 3; i++) {
                int temp;
                if (i == 0) {
                    temp = current-1;
                } else if (i == 1) {
                    temp = current+1;
                } else {
                    temp = current*2;
                }

                if (temp == k) {
                    System.out.println(check[current]);
                    return;
                }
                if(temp >= 0 && temp < check.length && check[temp] == 0){
                    que.add(temp);
                    check[temp] = check[current]+1;
                }
            }
        }
    }
}
