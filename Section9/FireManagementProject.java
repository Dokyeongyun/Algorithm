package Algorithm.Section9;

public class FireManagementProject {
    static int sty = 0, stx = 0;
    static int FIRE_MAX = 500;
    static int M = 5, N = 5, X = 2;
    static int[][] Building = new int[M][N];
    static int[][] Path = new int[M][N];
    static int[][] path = new int[M][N];
    static int[] dir = new int[]{0, 1, 2, 3, 4};
    static int res_n, res_y, res_x = 0;
    static boolean found = false;
    static int[][] MyQueue = new int[500][2];
    static int rear = 0, front = 0;
    static int yy, xx = 0;
    static int bound, count = 0;

    public static void main(String[] args) {
        int[][] MAP = {{500, 0, 0, 0, -1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 500, 500, 0}};

        FMP(M, N, X, MAP);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(Building[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(res_y + " " + res_x);
    }


    public static void FMP(int M, int N, int X, int[][] MAP) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (MAP[i][j] == 1) {
                    sty = i;
                    stx = j;
                }
            }
        }

        InsertData(sty, stx, 0, count + 1);
        bound = rear + 1;

        while (rear >= front) {
            RemoveData(yy, xx);
            if (front >= bound) {
                count++;
                if ((count > X) && ((count - 1) % X == 0))
                    Fire();
                bound = rear + 1;
            }

            if (Building[yy][xx] == 500)
                continue;
            if ((yy > 0) && (Building[yy - 1][xx] <= 0))
                InsertData(yy - 1, xx, 4, count + 2);
            if ((yy < M - 1) && (Building[yy + 1][xx] <= 0))
                InsertData(yy + 1, xx, 1, count + 2);
            if ((xx > 0) && (Building[yy][xx - 1] <= 0))
                InsertData(yy, xx - 1, 3, count + 2);
            if ((xx < N - 1) && (Building[yy][xx + 1] <= 0))
                InsertData(yy, xx + 1, 2, count + 2);

            if (found) {
                res_n = count + 1;
                break;
            }
        }
    }


    public static void InsertData(int y, int x, int dir, int count) {
        // y, x 를 Queue 에 저장
        MyQueue[rear][0] = y;
        MyQueue[rear][1] = x;

        System.out.println(y + " " + x);
        if(y==0&&x==4)
            return;
        // 현재 좌표가 출구라면
        if (Building[y][x] == -1) {
            System.out.println("출구");
            found = true;
            res_y = y;
            res_x = x;
        } else {
            Building[y][x] = count;
            path[y][x] = dir;
            rear++;
        }
    }

    // Queue 의 값을 하나 꺼내오고 front++ 함으로써 이후에 꺼낼 때 다음 값을 꺼낼 수 있도록
    public static void RemoveData(int y, int x) {
        y = MyQueue[front][0];
        x = MyQueue[front][1];
        yy = y;
        xx = x;
        front++;
    }

    // 불이 주변으로 번짐
    public static void Fire() {
        System.out.println("Fire");
        int i, j;
        for (i = 0; i < M; i++) {
            for (j = 0; j < N; j++) {
                if (Building[i][j] == 500) {
                    if (i > 0)
                        Path[i - 1][j] = 500;
                    if (j > 0)
                        Path[i][j - 1] = 500;
                    if (i < M - 1)
                        Path[i + 1][j] = 500;
                    if (j < N - 1)
                        Path[i][j + 1] = 500;
                } else {
                    for (i = 0; i < M; i++) {
                        for (j = 0; j < N; j++) {
                            if (Path[i][j] == 500)
                                Building[i][j] = 500;
                        }
                    }
                }
            }
        }
    }
}
