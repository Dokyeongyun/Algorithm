package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
n(1 ≤ n ≤ 100)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다.
각 버스는 한 번 사용할 때 필요한 비용이 있다.

모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 도시의 개수 n(1 ≤ n ≤ 100)이 주어지고 둘째 줄에는 버스의 개수 m(1 ≤ m ≤ 100,000)이 주어진다.
그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다.
버스의 정보는 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c로 이루어져 있다. 시작 도시와 도착 도시가 같은 경우는 없다.
비용은 100,000보다 작거나 같은 자연수이다.

시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.

출력
n개의 줄을 출력해야 한다. i번째 줄에 출력하는 j번째 숫자는 도시 i에서 j로 가는데 필요한 최소 비용이다.
만약, i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력한다.
 */
public class _11404 {
    static int n;
    static int[][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        distance = new int[n+1][n+1];

        for(int i=1; i <= n; i++) {
            for(int j=1; j <= n; j++) {
                if(i == j) continue;
                distance[i][j] = 1000000000;
            }
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            distance[start][end] = Math.min(distance[start][end], weight);
        }

        floydWarshall();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++) {
                if(distance[i][j] == 1000000000)
                    distance[i][j] = 0;

                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void floydWarshall() {
        for(int k = 1; k <= n; k++) {
            for(int i=1; i <= n; i++) {
                for(int j=1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }
}
