package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/5639
 */
public class BAEKJOON5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node tree = new Node(Integer.parseInt(br.readLine()));
        String temp = "";
        while ((temp = br.readLine()) != null && temp.length() != 0) {
            tree = restoreTree(tree, Integer.parseInt(temp));
        }
        postOrder(tree);
    }
    static void postOrder(Node tree){
        if (tree.left != null) postOrder(tree.left);
        if (tree.right != null) postOrder(tree.right);
        System.out.println(tree.value);
    }
    static Node restoreTree(Node node, int compare) {
        Node tempNode;
        if(node == null) return new Node(compare);

        if(node.value > compare) {
            tempNode = restoreTree(node.left, compare);
            node.left = tempNode;
        }else {
            tempNode = restoreTree(node.right, compare);
            node.right = tempNode;
        }
        return node;
    }

    static class Node{
        Node left;
        Node right;
        int value;
        Node(int value){
            this.value = value;
        }
    }
}
