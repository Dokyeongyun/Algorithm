package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] S = new String[N];
        for(int i=0; i<N; i++) S[i] = br.readLine();

        List<String> list = new ArrayList<>(Arrays.asList(S));

        int count = 0;

        for(int i=0; i<M; i++) if(list.contains(br.readLine())) count++;

        System.out.println(count);
    }
}
