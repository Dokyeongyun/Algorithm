package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/16235
 */
public class _16235 {

    static final int INITIAL_NUTRIMENT = 5;

    static int[][] nodes;
    static int[][] nutrients;

    static List<Tree> trees = new ArrayList<>();
    static List<Tree> deadTrees = new ArrayList<>();

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        nodes = new int[N + 1][N + 1];
        nutrients = new int[N + 1][N + 1];
        for (int r = 1; r < N + 1; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c < N + 1; c++) {
                nutrients[r][c] = Integer.parseInt(st.nextToken());
                nodes[r][c] = INITIAL_NUTRIMENT;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, z));
        }

        trees.sort(Comparator.comparingInt(t -> t.age));
        for (int i = 0; i < K; i++) {
            cycle();
        }

        System.out.println(trees.size());
    }

    private static void cycle() {
        // Spring
        for (Tree tree : trees) {
            if (!tree.canGrow()) {
                deadTrees.add(tree);
                continue;
            }
            tree.grow();
        }

        // Summer
        for (Tree tree : deadTrees) {
            tree.dead();
        }

        // Autumn
        ArrayList<Tree> newTrees = new ArrayList<>();
        for (Tree tree : trees) {
            if (tree.isDead()) {
                continue;
            }

            if (tree.canBreed()) {
                for (int i = 0; i < 8; i++) {
                    int nextR = tree.r + dr[i];
                    int nextC = tree.c + dc[i];
                    if (nextR < 1 || nextR >= nodes.length || nextC < 1 || nextC >= nodes.length) {
                        continue;
                    }

                    newTrees.add(new Tree(nextR, nextC, 1));
                }
            }
        }

        for (Tree tree : trees) {
            if (!tree.isDead()) {
                newTrees.add(tree);
            }
        }

        trees = newTrees;
        deadTrees = new ArrayList<>();

        // Winter
        for (int r = 1; r < nodes.length; r++) {
            for (int c = 1; c < nodes.length; c++) {
                nodes[r][c] += nutrients[r][c];
            }
        }
    }

    static class Tree {
        int r;
        int c;
        int age;
        boolean isDead;

        Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
            this.isDead = false;
        }

        public boolean canGrow() {
            return nodes[r][c] >= age;
        }

        public boolean canBreed() {
            if (isDead) {
                return false;
            }
            return age % 5 == 0;
        }

        public void grow() {
            nodes[r][c] -= age;
            age += 1;
        }

        public boolean isDead() {
            return isDead;
        }

        public void dead() {
            nodes[r][c] += age / 2;
            isDead = true;
        }

        @Override
        public String toString() {
            return "age: " + age;
        }
    }

}
