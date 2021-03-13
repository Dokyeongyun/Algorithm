package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEKJOON14425 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // List를 이용한 방법
//        usingList();

        // Map을 이용한 방법
        usingMap();
    }

    static void usingMap() throws IOException{
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            map.put(br.readLine(), 1);
        }
        int count = 0;
        for(int i=0; i<M; i++){
            if(map.get(br.readLine()) != null) count++;
        }
        System.out.println(count);
    }

    static void usingList() throws IOException{
        String[] S = new String[N];
        for(int i=0; i<N; i++) S[i] = br.readLine();
        List<String> list = new ArrayList<>(Arrays.asList(S));
        int count = 0;
        for(int i=0; i<M; i++) if(list.contains(br.readLine())) count++;
        System.out.println(count);
    }
}
