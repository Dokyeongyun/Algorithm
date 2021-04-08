package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1068
 */
public class BAEKJOON1068 {

    static ArrayList<Integer>[] list;
    static int root = 0, remove = 0, leafCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];
        for(int i=0; i<list.length; i++) list[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp==-1){
                root = i;
                continue;
            }
            list[temp].add(i);
        }

        remove = Integer.parseInt(br.readLine());

        if(remove == root){
            System.out.println(0);
            return;
        }

        BFS();
        if(leafCount==0){
            System.out.println(1);
        }else{
            System.out.println(leafCount);
        }

//        System.out.println("root: "+root);
//        for(int i=0; i<list.length; i++){
//            System.out.println(i+" "+list[i]);
//        }
    }

    static void BFS(){
        Queue<Integer> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int temp = que.poll();

            if(list[temp].isEmpty()) {
                leafCount++;
                continue;
            }
            for(int i=0; i<list[temp].size(); i++){
                int next = list[temp].get(i);

                if(next == remove) {
                    System.out.println(list[temp].size()+"daf"+temp);
                    if(list[temp].size()==1){
                        leafCount++;
                    }
                    continue;
                }

                que.add(next);
            }
        }
    }
}
/*
13
-1 0 0 2 2 4 4 6 6 1 9 7 7
11
 */