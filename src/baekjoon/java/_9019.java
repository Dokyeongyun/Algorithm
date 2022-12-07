package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9019
 */
public class _9019 {
    static int A, B;
    static boolean[] visit;
    static String[] command;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            System.out.println(BFS(A,B));
        }
    }

    static String BFS(int input, int output){
        command = new String[10000];
        visit = new boolean[10000];
        Arrays.fill(command, "");

        Queue<Integer> que = new LinkedList<>();
        visit[input] = true;
        que.add(input);

        while(!que.isEmpty()){
            int cur = que.poll();

            int D = (2*cur) % 10000;
            int S = (cur == 0) ? 9999 : cur-1;
            int L = (cur%1000) * 10 + cur/1000;
            int R = (cur%10) * 1000 + cur/10;

            if(!visit[D]){
                que.add(D);
                visit[D]=true;
                command[D]=command[cur] + "D";
            }
            if(!visit[S]){
                que.add(S);
                visit[S]=true;
                command[S]=command[cur] + "S";
            }
            if(!visit[L]){
                que.add(L);
                visit[L]=true;
                command[L]=command[cur] + "L";
            }
            if(!visit[R]){
                que.add(R);
                visit[R]=true;
                command[R]=command[cur] + "R";
            }
        }
        return command[output];
    }
}
