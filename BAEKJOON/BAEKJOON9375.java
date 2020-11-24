package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/9375
 */
public class BAEKJOON9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();
                if(!map.containsKey(type)){
                    map.put(type, 1);
                }else{
                    int temp = map.get(type);
                    map.put(type, temp+1);
                }
            }
            int count = 1;
            for (int temp : map.values()) {
                count *= temp + 1;
            }
            System.out.println(count-1);
        }
    }
}
