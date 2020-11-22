package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON1043 {
    static int n, m, k;
    static int count = 0;
    static ArrayList<Integer> party[];
    static ArrayList<Integer> people[];
    static ArrayList<Integer> know;
    static boolean visit[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        party = new ArrayList[m+1];
        for(int i=0; i<m+1; i++)
            party[i] = new ArrayList<>();

        people = new ArrayList[n+1];
        for(int i=0; i<n+1; i++)
            people[i] = new ArrayList<>();

        know = new ArrayList<>();
        visit = new boolean[m+1];

        for(int i=0; i<k; i++)
            know.add(Integer.parseInt(st.nextToken()));

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++) {
                int val = Integer.parseInt(st.nextToken());
                party[i].add(val);
                people[val].add(i);
            }
        }


        bfs();

        System.out.println(count);

    }
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<know.size(); i++) {
            for(int j=0; j<people[know.get(i)].size(); j++) {
                if(!visit[people[know.get(i)].get(j)]) {
                    visit[people[know.get(i)].get(j)] = true;
                    queue.add(people[know.get(i)].get(j));
                }
            }
        }

        while(!queue.isEmpty()) {
            int val = queue.poll();
            for(int i=0; i<party[val].size(); i++) {
                for(int j=0; j<people[party[val].get(i)].size(); j++) {
                    if(!visit[people[party[val].get(i)].get(j)]) {
                        visit[people[party[val].get(i)].get(j)] = true;
                        queue.add(people[party[val].get(i)].get(j));
                    }
                }
            }
        }

        for(int i=0; i<m; i++)
            if(!visit[i])
                count++;
    }
}
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] know = new boolean[n+1];
        boolean[] cantParty = new boolean[m];

        st = new StringTokenizer(br.readLine());
        int knowCount = Integer.parseInt(st.nextToken());
        for(int i=0; i<knowCount; i++){
            know[Integer.parseInt(st.nextToken())] = true;
        }

        ArrayList<Integer>[] partyList = new ArrayList[m];

        for(int i=0; i<m; i++){
            partyList[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partyCount = Integer.parseInt(st.nextToken());
            for(int j=0; j<partyCount; j++){
                partyList[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0; i<partyList.length; i++){
            System.out.println(partyList[i]);
        }

        while(true){
            boolean exit = false;
            for(int i=0; i<cantParty.length; i++){
                if(!cantParty[i]){
                    break;
                }
                exit = true;
            }
            if(exit) break;


            for(int i=0; i<partyList.length; i++){
                for(int j=0; j<partyList[i].size(); j++){
                    if(know[partyList[i].get(j)]){
                        cantParty[partyList[i].get(j)] = true;
                    }
                }
            }
        }
    }
}*/
/*
4 3
3 2 3 4
2 1 2
1 3
3 2 3 4
 */