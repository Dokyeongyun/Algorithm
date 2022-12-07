package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1953
 */
public class _1953 {

    static final char TEAM_BLUE = 'B';
    static final char TEAM_WHITE = 'W';

    static List<Integer>[] students;
    static char[] teams;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        students = new ArrayList[n + 1];
        for (int i = 1; i < students.length; i++) {
            students[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int numberOfHaters = Integer.parseInt(st.nextToken());

            for (int j = 0; j < numberOfHaters; j++) {
                students[i + 1].add(Integer.parseInt(st.nextToken()));
            }
        }

        teams = new char[n + 1];
        Arrays.fill(teams, '-');

        visited = new boolean[n + 1];
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, TEAM_BLUE);
            }
        }

        List<Integer> blues = new ArrayList<>();
        List<Integer> whites = new ArrayList<>();

        for (int i = 1; i < teams.length; i++) {
            if (teams[i] == TEAM_BLUE) {
                blues.add(i);
            } else {
                whites.add(i);
            }
        }

        Collections.sort(blues);
        Collections.sort(whites);

        System.out.println(blues.size());
        for (int i : blues) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(whites.size());
        for (int i : whites) {
            System.out.print(i + " ");
        }
    }

    static void dfs(int start, char team) {
        teams[start] = team;

        for (int next : students[start]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, team == TEAM_BLUE ? TEAM_WHITE : TEAM_BLUE);
            }
        }
    }
}
