package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1431
 */
public class _1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] serials = new String[N];

        // 입력
        for(int i=0; i<N; i++) serials[i] = br.readLine();

        // 정렬
        // A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
        // 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
        // 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
        Arrays.sort(serials , (o1, o2) -> {
            if(o1.length()<o2.length()) return -1;
            else if(o1.length()==o2.length()) {
                if(add(o1)==add(o2)) return o1.compareTo(o2);
                else return Integer.compare(add(o1), add(o2));
            } else return 1;
        });

        // 출력
        for(String i: serials) System.out.println(i);

    }
    public static int add(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)>='0' && s.charAt(i)<='9') sum += s.charAt(i)-'0';
        return sum;
    }
}
