package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14425 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

         // List를 이용한 방법
//        usingList();

         // Map을 이용한 방법
//        usingMap();


        // Trie를 이용한 방법

        // Trie 구성
        Trie root = new Trie();
        for(int i=0; i<N; i++){
            String temp = br.readLine();

            Trie curTrie = root;

            for(int j=0; j<temp.length(); j++){
                char c = temp.charAt(j);
                if(curTrie.nextNode[c-'a'] == null) curTrie.nextNode[c-'a'] = new Trie();
                curTrie = curTrie.nextNode[c-'a'];
                if(j == temp.length()-1) curTrie.isFinished = true;
            }
        }

        // Trie에서 찾기
        int count = 0;
        for(int i=0; i<M; i++){
            String temp = br.readLine();

            Trie curTrie = root;

            for(int j=0; j<temp.length(); j++){
                char c = temp.charAt(j);
                if(curTrie.nextNode[c-'a'] == null) break;
                curTrie = curTrie.nextNode[c-'a'];
                if(j==temp.length()-1 && curTrie.isFinished) count++;
            }
        }
        System.out.println(count);
    }

    static class Trie {
        Trie[] nextNode = new Trie[26];
        boolean isFinished;

        Trie() {}
    }

    // Map을 이용한 풀이 => 시간복잡도 O(1)
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

    // List를 이용한 풀이 => 시간복잡도 O(n)
    static void usingList() throws IOException{
        String[] S = new String[N];
        for(int i=0; i<N; i++) S[i] = br.readLine();
        List<String> list = new ArrayList<>(Arrays.asList(S));
        int count = 0;
        for(int i=0; i<M; i++) if(list.contains(br.readLine())) count++;
        System.out.println(count);
    }
}
