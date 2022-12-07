package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 */
public class _2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        ArrayList<Integer> xFactor = new ArrayList<>();
        ArrayList<Integer> yFactor = new ArrayList<>();
        for(int i=1; i<=x; i++){
            if(x%i==0) xFactor.add(i);
        }
        for(int i=1; i<=y; i++){
            if(y%i==0) yFactor.add(i);
        }

        int gcd = 1;
        for (Integer value : xFactor) {
            for (Integer integer : yFactor) {
                if (value.equals(integer)) {
                    gcd = value;
                    break;
                }
            }
        }
        int xTemp = x;
        int yTemp = y;

        int lcm = 0;
        while(true){
            if(xTemp==yTemp) {
                lcm = xTemp;
                break;
            }
            if(xTemp < yTemp){
                xTemp +=x;
            }else {
                yTemp +=y;
            }
        }
        System.out.println(gcd);
        System.out.println(lcm);
        System.out.println(xFactor);
        System.out.println(yFactor);
    }
}
