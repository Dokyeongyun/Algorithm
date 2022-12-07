package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1126 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());

        double min = 0;
        double max = Math.max(L, Math.max(W, H));

        for(int i=0; i<10000; i++){
            double mid = (min + max)/2;
            if((long) (L/mid) * (long) (W/mid)*(long)(H/mid)>=N) {
                min = mid;
            }else{
                max = mid;
            }
        }
        System.out.println(min);
    }
}
