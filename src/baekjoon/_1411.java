package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1411
 */
public class _1411 {
/*
5
aa
ab
bb
cc
cd
 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for(int i=0; i<N; i++){
            words[i] = br.readLine();
        }

        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(isShom(words[i], words[j])) count++;
            }
        }
        System.out.println(count);
    }

    static boolean isShom(String s1, String s2) {
        char[] visit1 = new char[26];
        char[] visit2 = new char[26];

        Arrays.fill(visit1, (char) 0);
        Arrays.fill(visit2, (char) 0);

        for (int k = 0; k < s1.length(); k++) {
            int temp1 = s1.charAt(k)-'a';
            int temp2 = s2.charAt(k)-'a';
            if (visit1[temp1] == 0 && visit2[temp2] == 0) {
                visit1[temp1] = s2.charAt(k);
                visit2[temp2] = s1.charAt(k);
            } else if (visit1[temp1] != s2.charAt(k) || visit2[temp2] != s1.charAt(k)) {
                return false;
            }
        }
        return true;
    }
}
