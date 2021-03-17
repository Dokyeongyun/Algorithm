package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1263
 */
public class BAEKJOON1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Task[] tasks = new Task[N];

        // 입력받기
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            tasks[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // Si 순으로 정렬
        Arrays.sort(tasks);

        // 가장 늦은 시작시간 구하기
        int ans = tasks[N-1].s - tasks[N-1].t;
        for (int i=tasks.length-2; i>=0; i--) {
            tasks[i].s = Math.min(tasks[i].s, ans);
            ans = tasks[i].s - tasks[i].t;
        }

        // 출력
        System.out.println(ans > 0 ? ans : -1);
    }

    static class Task implements Comparable<Task> {
        int t;
        int s;
        Task(int t, int s){
            this.t = t;
            this.s = s;
        }

        @Override
        public int compareTo(Task o) {
            if(o.s > s){
                return -1;
            }else if(o.s < s){
                return 1;
            }else{
                return t <= o.t ? -1 : 1;
            }
        }

        @Override
        public String toString() {
            return t+" "+s;
        }
    }
}
