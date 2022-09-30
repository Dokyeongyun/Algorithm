package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13305
 */
public class _13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N];
        int[] distance = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<distance.length; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cost.length; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int temp = cost[0];

        for(int i = 0; i < cost.length-1; i++) {
            if(cost[i] < temp) {
                temp = cost[i];
            }
            sum += (temp * distance[i]);
        }
        System.out.println(sum);
    }
}
