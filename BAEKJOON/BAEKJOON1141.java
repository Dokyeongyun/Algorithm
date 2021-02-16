package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.acmicpc.net/problem/1141
 */
public class BAEKJOON1141 {
    static int N;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for(int i=0; i<N; i++) {
            words[i] = br.readLine();
        }

        Set<String> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            String origin = words[i];
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(i != j) {
                    String comp = words[j];
                    if(origin.length() <= comp.length()) {
                        for(int k = 0; k < origin.length(); k++) {
                            if(origin.equals(comp)) {
                                count++;
                                break;
                            }
                            if(origin.charAt(k) != comp.charAt(k)) {
                                count++;
                                break;
                            }
                        }
                    } else {
                        count++;
                    }
                }
            }
            if(count == N-1) {
                set.add(origin);
            }
        }
        System.out.println(set.size());
    }
}
