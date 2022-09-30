package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1759
 */
public class _1759 {
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static char[] alphabets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabets = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) alphabets[i] = st.nextToken().charAt(0);

        Arrays.sort(alphabets);
        backtracking(0, "");
        System.out.println(sb);
    }

    static void backtracking(int index, String password) {
        if (password.length() == L) {
            if (check(password)) sb.append(password).append("\n");
            return;
        }
        if (index >= C) return;

        backtracking(index + 1, password + alphabets[index]);
        backtracking(index + 1, password);
    }

    static boolean check(String password){
        int mo = 0;
        int ja = 0;
        for(int i=0; i<password.length(); i++){
            char temp = password.charAt(i);
            if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') mo++;
            else ja++;
        }
        return mo >=1 && ja >= 2;
    }
}
