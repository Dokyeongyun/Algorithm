package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2263
 */
public class _2263 {

    static int N;
    static int[] inOrder;
    static int[] postOrder;
    static int postOrderIndex;
    static Node[] nodes;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nodes = new Node[N + 1];
        inOrder = new int[N];
        postOrder = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        postOrderIndex = N - 1;
        makeTree(0, N - 1, postOrder[N - 1]);

//        System.out.println(Arrays.toString(nodes));

        preOrder(postOrder[N-1]);
        System.out.println(sb);
    }

    static void preOrder(int parent){
        sb.append(parent+" ");
        if(nodes[parent].leftNode != 0){
            preOrder(nodes[parent].leftNode);
        }
        if(nodes[parent].rightNode != 0){
            preOrder(nodes[parent].rightNode);
        }
    }

    static int makeTree(int start, int end, int value) {
//        System.out.println(start + " " + end + " " + value + " " + " " + postOrder[postOrderIndex]);
//        System.out.println(Arrays.toString(nodes));
        if (start > end) return 0;

        int index = 0;
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == value) {
                index = i;
                break;
            }
        }

        postOrderIndex--;

        if(postOrderIndex < 0) return value;
        nodes[value].rightNode = makeTree(index + 1, end, postOrder[postOrderIndex]);
        if(postOrderIndex < 0) return value;
        nodes[value].leftNode = makeTree(start, index - 1, postOrder[postOrderIndex]);

        return value;
    }

    static class Node {
        int value;
        int leftNode;
        int rightNode;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + " " + leftNode + " " + rightNode;
        }
    }
}
/*
9
2 4 1 7 5 3 8 6 9
4 2 7 5 8 9 6 3 1
 */