package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON16236 {
    static int n;
    static int[][] arr;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int sharkSize = 2;
    static Point sharkPosition;
    static int ateFishCnt = 0;
    static boolean[][] visit;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if(temp == 9){
                    sharkPosition = new Point(i, j, 0);
                    arr[i][j] = 0;
                }
            }
        }
        BFS();
    }

    static void BFS(){
        while(true){
            visit = new boolean[n][n];
            List<Point> fishList = new LinkedList<>();
            Queue<Point> que = new LinkedList<>();
            que.add(sharkPosition);
            visit[sharkPosition.x][sharkPosition.y] = true;

            while(!que.isEmpty()) {
                Point cur = que.poll();
                int curX = cur.x;
                int curY = cur.y;
                int curD = cur.d;

                for (int i = 0; i < 4; i++) {
                    int nextX = curX + dx[i];
                    int nextY = curY + dy[i];

                    // 범위밖 or 이미 방문했던 곳이면 ㅌㅌ
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visit[nextX][nextY]) {
                        continue;
                    }

                    if (arr[nextX][nextY] >= 1 && arr[nextX][nextY] < sharkSize) {
                        que.add(new Point(nextX, nextY, curD + 1));
                        fishList.add(new Point(nextX, nextY, curD + 1));
                        visit[nextX][nextY] = true;
                    } else if (arr[nextX][nextY] == sharkSize || arr[nextX][nextY] == 0) {
                        que.add(new Point(nextX, nextY, curD + 1));
                        visit[nextX][nextY] = true;
                    }
                }
            }
                // 먹을 수 있는 물고기가 없으면
                if(fishList.size() == 0) {
                    System.out.println(time);
                    return;
                }

                // 먹을 물고기가 있으면
                // -> 가장 가까운 거리의 물고기 선택
                // -> 가까운 물고기가 여러마리이면 가장 위, 가장 왼쪽의 물고기 선택
                Point temp = fishList.get(0);
                for(int i = 1; i < fishList.size(); i++){
                    if(fishList.get(i).d < temp.d) {
                        temp = fishList.get(i);
                    }
                    if(temp.d == fishList.get(i).d) {
                        if(temp.x > fishList.get(i).x){
                            temp = fishList.get(i);
                        }
                    }
                }

                // 물고기 먹은 후
                // -> 그 자리 0으로 / 물고기거리만큼 time++ / 먹은 물고기 카운트++
                time += temp.d;
                ateFishCnt++;
                arr[temp.x][temp.y] = 0;

                // 먹은 물고기의 수가 아기 상어의 크기와 같으면 크기++, 먹은 물고기 0 갱신
                if(ateFishCnt == sharkSize) {
                    sharkSize++;
                    ateFishCnt = 0;
                }

                sharkPosition = new Point(temp.x, temp.y, 0);
        }
    }

    static class Point{
        int x;
        int y;
        int d;
        Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public String toString() {
            return x +" " + y + " "+ d;
        }
    }
}
