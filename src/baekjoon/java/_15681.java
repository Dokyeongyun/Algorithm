package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15681 {
    static List<Integer>[] connect;
    static List<Node> nodeList;
    static int[] subTreeCountList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 트리의 정점의 수
        int R = Integer.parseInt(st.nextToken()); // 루트 번호
        int Q = Integer.parseInt(st.nextToken()); // 쿼리의 수

        nodeList = new ArrayList<>();
        subTreeCountList = new int[N+1];
        connect = new ArrayList[N+1];
        for(int i=1; i<connect.length; i++){
            connect[i] = new ArrayList<>();
        }
        for(int i=0; i<=N; i++){
            nodeList.add(new Node(i));
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            connect[start].add(end);
            connect[end].add(start);
        }
        makeTree(R, -1);
        childNodeCnt(R);
        for(int i=0; i<Q; i++){
            int root = Integer.parseInt(br.readLine());
            System.out.println(subTreeCountList[root]);
        }
    }
    static void childNodeCnt(int curNode){
        subTreeCountList[curNode] = 1;
        for(int i=0; i<nodeList.get(curNode).childNode.size(); i++){
            int temp = nodeList.get(curNode).childNode.get(i);
            childNodeCnt(temp);
            subTreeCountList[curNode] += subTreeCountList[temp];
        }
    }

    static void makeTree(int curNode, int parent){
        for(int i=0; i<connect[curNode].size(); i++){
            int temp = connect[curNode].get(i);
            if(temp != parent){
                nodeList.get(curNode).childNode.add(temp);
                nodeList.get(temp).parentNode = curNode;
                makeTree(temp, curNode);
            }
        }
    }
    static class Node {
        int no;
        int parentNode;
        List<Integer> childNode = new ArrayList<>();

        Node(int no){
            this.no = no;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", parentNode=" + parentNode +
                    ", childNode=" + childNode +
                    '}';
        }
    }
}
