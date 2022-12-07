package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/3190
 */
public class _3190 {
    static final int BLANK = 0;
    static final int SNAKE = 1;
    static final int APPLE = 2;

    static final Direction LEFT = new Direction(0, -1);
    static final Direction RIGHT = new Direction(0, 1);
    static final Direction UP = new Direction(-1, 0);
    static final Direction DOWN = new Direction(1, 0);

    static final char LEFT_TURN_KEY = 'L';
    static final char RIGHT_TURN_KEY = 'D';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] board = new int[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = APPLE;
        }

        int L = Integer.parseInt(br.readLine());
        char[] turnAbouts = new char[10001];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            turnAbouts[X] = C;
        }

        int second = 0;
        Direction currentDirection = RIGHT;
        Snake snake = new Snake(new Node(1, 1));
        board[1][1] = SNAKE;
        while (true) {
            second++;

            try {
                Node head = snake.getHead().orElseThrow();
                Node tail = snake.getTail().orElseThrow();
                Node nextNode = head.nextNode(currentDirection);

                if (nextNode.x < 1 || nextNode.y < 1 || nextNode.x >= board.length || nextNode.y >= board.length
                        || nextNode.equals(tail)
                        || board[nextNode.x][nextNode.y] == SNAKE) {
                    break;
                }

                if (board[nextNode.x][nextNode.y] == APPLE) {
                    board[nextNode.x][nextNode.y] = SNAKE;
                    snake.add(new Node(nextNode.x, nextNode.y));
                } else {
                    board[nextNode.x][nextNode.y] = SNAKE;
                    snake.add(new Node(nextNode.x, nextNode.y));
                    board[tail.x][tail.y] = BLANK;
                    snake.remove();
                }

                if (snake.length() == 0) {
                    break;
                }

                if (turnAbouts[second] == RIGHT_TURN_KEY || turnAbouts[second] == LEFT_TURN_KEY) {
                    currentDirection = currentDirection.nextDirection(turnAbouts[second]);
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

        System.out.println(second);
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node nextNode(Direction direction) {
            return new Node(this.x + direction.x, this.y + direction.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    static class Direction {
        int x;
        int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Direction nextDirection(char turnDirection) {
            if (UP.equals(this)) {
                return (turnDirection == RIGHT_TURN_KEY) ? RIGHT : LEFT;
            } else if (RIGHT.equals(this)) {
                return (turnDirection == RIGHT_TURN_KEY) ? DOWN : UP;
            } else if (DOWN.equals(this)) {
                return (turnDirection == RIGHT_TURN_KEY) ? LEFT : RIGHT;
            } else if (LEFT.equals(this)) {
                return (turnDirection == RIGHT_TURN_KEY) ? UP : DOWN;
            }

            return null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Direction direction = (Direction) o;

            if (x != direction.x) return false;
            return y == direction.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    static class Snake {

        List<Node> body = new LinkedList<>();

        Snake(Node node) {
            this.body.add(node);
        }

        public int length() {
            return this.body.size();
        }

        public void add(Node node) {
            this.body.add(0, node);
        }

        public Optional<Node> remove() {
            if (this.body.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(this.body.remove(this.body.size() - 1));
        }

        public Optional<Node> getHead() {
            if (this.body.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(this.body.get(0));
        }

        public Optional<Node> getTail() {
            if (this.body.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(this.body.get(this.body.size() - 1));
        }
    }
}