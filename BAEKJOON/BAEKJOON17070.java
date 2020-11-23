package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON17070 {
    static int n;
    static int count;
    static int[][] arr;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for(int i=1; i<arr.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<arr.length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList[3];
        for(int i = 0; i<3; i++){
            list[i] = new ArrayList<>();
        }
        list[0].add(0);
        list[0].add(1);
        list[1].add(0);
        list[1].add(1);
        list[1].add(2);
        list[2].add(1);
        list[2].add(2);

        bfs(1, 2, 0);
        System.out.println(count);
    }

    static void bfs(int x, int y, int shape){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y, shape));

        while(!que.isEmpty()){
            Node curNode = que.poll();
            int curX = curNode.x;
            int curY = curNode.y;
            int curShape = curNode.shape;

            if(curX == n && curY == n){
                count++;
                continue;
            }

            for(int i=0; i<list[curShape].size(); i++){
                int nextShape = list[curShape].get(i);
                int nextX = curX;
                int nextY = curY;

                switch(nextShape){
                    case 0:
                        nextY++;
                        break;
                    case 1:
                        nextX++;
                        nextY++;
                        break;
                    case 2:
                        nextX++;
                        break;
                }

                // nextX, nextY가 이동 가능한 지역인지?
                if(rangeCheck(nextX, nextY, nextShape)){
                    que.add(new Node(nextX, nextY, nextShape));
                }
//                System.out.println(que);
            }
        }
    }

    static boolean rangeCheck2(int x, int y){
        return x > 0 && x <= n && y > 0 && y <= n;
    }
    static boolean rangeCheck(int x, int y, int shape){
        if(rangeCheck2(x, y)){
            if(shape == 1){
                return arr[x - 1][y] != 1 && arr[x][y - 1] != 1 && arr[x][y] != 1;
            }else{
                return arr[x][y] != 1;
            }
        }else{
            return false;
        }
    }
    static class Node{
       int x;
       int y;
       int shape;
       Node(int x, int y, int shape){
           this.x = x;
           this.y = y;
           this.shape = shape;
       }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    ", shape=" + shape +
                    '}';
        }
    }
}
