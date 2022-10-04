package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/9370
 */
public class _9370 {

    static List<Node>[] adjacentNodeList;
    static boolean[] isConditionMet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 교차로 개수
            int m = Integer.parseInt(st.nextToken()); // 도로 개수
            int t = Integer.parseInt(st.nextToken()); // 목적지 후보 개수

            adjacentNodeList = new ArrayList[n + 1];
            for (int i = 0; i < adjacentNodeList.length; i++) {
                adjacentNodeList[i] = new ArrayList<>();
            }
            isConditionMet = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 출발지
            int g = Integer.parseInt(st.nextToken()); // 경유지1
            int h = Integer.parseInt(st.nextToken()); // 경유지2

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 도로 시작
                int b = Integer.parseInt(st.nextToken()); // 도로 끝
                int d = Integer.parseInt(st.nextToken()); // 도로 길이

                adjacentNodeList[a].add(new Node(b, d, false));
                adjacentNodeList[b].add(new Node(a, d, false));
            }

            dijkstra(n, s, g, h);

            List<Integer> xList = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine()); // 목적지 후보
                xList.add(x);
            }

            Collections.sort(xList);
            for (int x : xList) {
                if (isConditionMet[x]) {
                    System.out.print(x + " ");
                }
            }
            System.out.println();
        }
    }

    private static void dijkstra(int numberOfNodes, int startNodeId, int waypointNode1Id, int waypointNode2Id) {
        boolean[] visit = new boolean[numberOfNodes + 1];
        long[] distance = new long[numberOfNodes + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startNodeId, 0, false));
        distance[startNodeId] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (visit[curNode.id]) {
                continue;
            }

            isConditionMet[curNode.id] = curNode.isLayover;
            visit[curNode.id] = true;

            for (Node nextNode : adjacentNodeList[curNode.id]) {
                if (!visit[nextNode.id]) {

                    if (distance[nextNode.id] >= distance[curNode.id] + nextNode.distance) {
                        distance[nextNode.id] = distance[curNode.id] + nextNode.distance;

                        boolean isLayover = curNode.isLayover;
                        if (!isLayover) {
                            if (curNode.id == waypointNode1Id && nextNode.id == waypointNode2Id ||
                                    nextNode.id == waypointNode1Id && curNode.id == waypointNode2Id) {
                                isLayover = true;
                                isConditionMet[nextNode.id] = true;
                            }
                        }
                        queue.add(new Node(nextNode.id, distance[nextNode.id], isLayover));
                    }
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int id;
        long distance;
        boolean isLayover;

        Node(int id, long distance, boolean isLayover) {
            this.id = id;
            this.distance = distance;
            this.isLayover = isLayover;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            } else if (this.distance == o.distance) {
                if (this.isLayover && o.isLayover) {
                    return 0;
                } else if (this.isLayover) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %s)", id, distance, isLayover);
        }
    }
}
