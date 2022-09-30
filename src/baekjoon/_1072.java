package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1072
 */
public class _1072 {
    static long X, Y, firstOdds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        firstOdds = Y*100/X ;

        if(X==Y || firstOdds==99){
            System.out.println(-1);
            return;
        }

        binarySearch(1, X);

/*        int count = 0;
        while(true){
            count++; X++; Y++;
            long odds = Y*100/X ;
            if(firstOdds != odds) break;
        }
        System.out.println(count);*/
    }

    static void binarySearch(long start, long end) {
        long mid = 0, ratio = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            ratio = (Y + mid) * 100 / (X + mid);

            if (ratio > firstOdds) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
}
