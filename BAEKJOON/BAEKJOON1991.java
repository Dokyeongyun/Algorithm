package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.



예를 들어 위와 같은 이진 트리가 입력되면,

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

입력
첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다.
둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다.
자식 노드가 없는 경우에는 .으로 표현된다.

출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
 */
public class BAEKJOON1991 {
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new Node[n];

        // 트리 배열에 A부터 주어진 노드 개수만큼의 노드를 추가
        // 0-A, 1-B, 2-C, 3-D, 4-E, 5-F ...
        for (int i = 0; i < n; i++) {
            tree[i] = new Node((char) ('A' + i));
        }


        // 트리 구성
        for(int i=0; i<n; i++){
            String[] split = br.readLine().split(" ");
            char root = split[0].charAt(0);
            char left = split[1].charAt(0);
            char right = split[2].charAt(0);

            // 자식노드 추가
            if(left!='.'){
                tree[root-'A'].left = tree[left-'A'];
            }
            if(right!='.'){
                tree[root-'A'].right = tree[right-'A'];
            }
        }

        // 루트노드인 A의 인덱스 0 을 넣어줌
        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        System.out.println(sb);
    }

    //전위 순회 (루트->왼쪽자식->오른쪽자식)
    public static void preorder(int index){
        // 루트노드 방문
        sb.append(tree[index].data);
        // 왼쪽자식 방문
        if (tree[index].left != null) {
            preorder(tree[index].left.data - 'A');
        }
        // 오른쪽자식 방문
        if (tree[index].right != null) {
            preorder(tree[index].right.data - 'A');
        }
    }

    // 중위 순회 (왼쪽자식->루트->오른쪽자식)
    public static void inorder(int index){
        if (tree[index].left != null) {
            inorder(tree[index].left.data - 'A');
        }
        sb.append(tree[index].data);
        if (tree[index].right != null) {
            inorder(tree[index].right.data - 'A');
        }
    }

    // 후위 순회 (왼쪽자식->오른쪽자식->루트)
    public static void postorder(int index){
        if (tree[index].left != null) {
            postorder(tree[index].left.data - 'A');
        }
        if (tree[index].right != null) {
            postorder(tree[index].right.data - 'A');
        }
        sb.append(tree[index].data);
    }


    public static class Node{
        char data;
        Node left, right;
        Node(char data){
            this.data = data;
        }
    }
}
