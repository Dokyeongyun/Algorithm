package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13460
 */
public class _13460 {

    static final char WALL = '#';
    static final char HOLE = 'O';
    static final char EMPTY = '.';
    static final char RED_MARBLE = 'R';
    static final char BLUE_MARBLE = 'B';

    static int N, M;
    static char[][] map;
    static Marble redMarble, blueMarble;
    static Node holeNode;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == RED_MARBLE) {
                    redMarble = new Marble(i, j);
                }
                if (map[i][j] == BLUE_MARBLE) {
                    blueMarble = new Marble(i, j);
                }
                if (map[i][j] == HOLE) {
                    holeNode = new Node(i, j);
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<MovingMarble> queue = new LinkedList<>();
        queue.add(new MovingMarble(redMarble, blueMarble, 1));
        boolean[][] redVisit = new boolean[N][M];
        boolean[][] blueVisit = new boolean[N][M];

        redVisit[redMarble.position.x][redMarble.position.y] = true;
        blueVisit[blueMarble.position.x][blueMarble.position.y] = true;

        while (!queue.isEmpty()) {
            MovingMarble curMarble = queue.poll();

            if (curMarble.moveCount > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                boolean isBlueHole = false;
                Marble nextBlue = new Marble(curMarble.blueMarble);
                while (map[nextBlue.position.x + dx[i]][nextBlue.position.y + dy[i]] != WALL) {
                    nextBlue.position.x += dx[i];
                    nextBlue.position.y += dy[i];

                    if (nextBlue.position.equals(holeNode)) {
                        isBlueHole = true;
                        break;
                    }
                }

                if (isBlueHole) {
                    continue;
                }

                boolean isRedHole = false;
                Marble nextRed = new Marble(curMarble.redMarble);
                while (map[nextRed.position.x + dx[i]][nextRed.position.y + dy[i]] != WALL) {
                    nextRed.position.x += dx[i];
                    nextRed.position.y += dy[i];

                    if (nextRed.position.equals(holeNode)) {
                        isRedHole = true;
                        break;
                    }
                }

                if (isRedHole) {
                    return curMarble.moveCount;
                }

                if (nextRed.position.equals(nextBlue.position)) {
                    if (i == 0) {
                        if (curMarble.redMarble.position.x > curMarble.blueMarble.position.x) {
                            nextRed.position.x -= dx[i];
                        } else {
                            nextBlue.position.x -= dx[i];
                        }
                    } else if (i == 1) {
                        if (curMarble.redMarble.position.y < curMarble.blueMarble.position.y) {
                            nextRed.position.y -= dy[i];
                        } else {
                            nextBlue.position.y -= dy[i];
                        }
                    } else if (i == 2) {
                        if (curMarble.redMarble.position.x < curMarble.blueMarble.position.x) {
                            nextRed.position.x -= dx[i];
                        } else {
                            nextBlue.position.x -= dx[i];
                        }
                    } else {
                        if (curMarble.redMarble.position.y > curMarble.blueMarble.position.y) {
                            nextRed.position.y -= dy[i];
                        } else {
                            nextBlue.position.y -= dy[i];
                        }
                    }
                }

                if (redVisit[nextRed.position.x][nextRed.position.y] &&
                        blueVisit[nextBlue.position.x][nextBlue.position.y]) {
                    continue;
                }

                redVisit[nextRed.position.x][nextRed.position.y] = true;
                blueVisit[nextBlue.position.x][nextBlue.position.y] = true;
                queue.add(new MovingMarble(nextRed, nextBlue, curMarble.moveCount + 1));
            }
        }

        return -1;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return this.x == ((Node) obj).x && this.y == ((Node) obj).y;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }

    static class MovingMarble {
        Marble redMarble;
        Marble blueMarble;
        int moveCount;

        public MovingMarble(Marble redMarble, Marble blueMarble, int moveCount) {
            this.redMarble = redMarble;
            this.blueMarble = blueMarble;
            this.moveCount = moveCount;
        }

        @Override
        public String toString() {
            return "MovingMarble{" +
                    "redMarble=" + redMarble +
                    ", blueMarble=" + blueMarble +
                    ", moveCount=" + moveCount +
                    '}';
        }
    }

    static class Marble {
        Node position;

        public Marble(Marble marble) {
            this.position = new Node(marble.position.x, marble.position.y);
        }

        public Marble(int x, int y) {
            this.position = new Node(x, y);
        }

        @Override
        public String toString() {
            return position.toString();
        }
    }
}
