package baekjoon;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1107
 */
public class _1107 {

    static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        for(int i=0; i<m; i++){
            broken[scan.nextInt()] = true; // 고장난 버튼 true
        }

        int minCount = Math.abs(n - 100); // 현재 채널 100번, +- 만으로 이동하는 최소횟수

        for(int i=0; i<1000000; i++){
            int count = Check(i); // 고장나지 않은 숫자로만 이루어진 경우 Check, 0이면 불가능
            if(count != 0){
                minCount = Math.min(minCount, (count + Math.abs(i-n)));
            }
        }

        System.out.println(minCount);
    }
    private static int Check(int n){
        if(n == 0 && !broken[0]){
            return 1;
        }
        int count = 0;

        while(n > 0){
            if(broken[n%10]) return 0;
            count++;
            n /= 10;
        }
        return count;
    }
}
