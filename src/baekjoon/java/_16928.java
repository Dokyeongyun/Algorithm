package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/16928
 */
public class _16928 {
    static int[] laddersAndSnakes;
    static int[] count;
    static int[] dice = new int[]{1, 2, 3, 4, 5, 6};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        laddersAndSnakes = new int[101];
        count = new int[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            laddersAndSnakes[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        BFS();
        System.out.println(count[100]);

    }

    static void BFS() {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);

        while(!que.isEmpty()){
            int cur = que.poll();
            int curCount = count[cur];

            if(cur == 100) break;

            for(int i=0; i<dice.length; i++){
                int next = cur + dice[i];
                int nextCount = curCount + 1;

                if(next > 100) continue;

                if(count[next] != 0) continue;

                if(laddersAndSnakes[next] != 0) {
                    if(count[laddersAndSnakes[next]] != 0) continue;
                    count[laddersAndSnakes[next]] = nextCount;
                    que.add(laddersAndSnakes[next]);
                    continue;
                }

                count[next] = nextCount;
                que.add(next);
            }
        }

    }
}
