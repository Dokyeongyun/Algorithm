package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON16953 {
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        BFS();
    }

    static void BFS(){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(A, 0));

        while(!que.isEmpty()){
            Node cur = que.poll();
            long curValue = cur.value;
            int curCount = cur.count;

            if(curValue == B) {
                System.out.println(curCount+1);
                return;
            }

            if(curValue*2 <= B){
                que.add(new Node(curValue*2, curCount+1));
            }
            if(curValue*10+1 <= B){
                que.add(new Node(curValue*10+1, curCount+1));
            }
        }
        System.out.println(-1);
    }
    static class Node{
        long value;
        int count;
        Node(long value, int count){
            this.value = value;
            this.count = count;
        }
    }
}
