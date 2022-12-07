package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1057
 */
public class _1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Kim = Integer.parseInt(st.nextToken());
        int Lim = Integer.parseInt(st.nextToken());

        int round = 0;

        while(true){
            System.out.println(Kim+" "+Lim);
            N = N%2==0 ? N/2 : N/2+1;
            round++;
//            if(N==1) break;

            // 이번 라운드에 만나는지 체크
            int bigger = Math.max(Kim, Lim);
            int smaller = Math.min(Kim, Lim);
            if(bigger%2 != 1 && bigger - smaller == 1) break;

            // 안만나면 다음 번호 부여
            if(Kim==1){
                Lim = Lim%2 == 0 ? Lim/2 : Lim/2+1;
                continue;
            }else if(Lim==1){
                Kim = Kim%2 == 0 ? Kim/2 : Kim/2+1;
                continue;
            }

            Kim = Kim%2 == 0 ? Kim/2 : Kim/2+1;
            Lim = Lim%2 == 0 ? Lim/2 : Lim/2+1;
        }

        System.out.println(round);
    }
}
