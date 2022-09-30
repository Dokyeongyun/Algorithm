package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/7662
 */
public class _7662 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i=0; i<k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (op){
                    case "I":
                        if(map.containsKey(num)){
                            map.put(num, map.get(num)+1);
                        }else{
                            map.put(num, 1);
                        }
                        break;
                    case "D":
                        if(map.isEmpty()) break;

                        if(num==1){
                            int maxNum = map.get(map.lastKey());
                            if(maxNum-1 == 0){
                                map.remove(map.lastKey());
                            }else{
                                map.put(map.lastKey(), maxNum-1);
                            }
                        }else{
                            int minNum = map.get(map.firstKey());
                            if(minNum-1 == 0){
                                map.remove(map.firstKey());
                            }else{
                                map.put(map.firstKey(), minNum-1);
                            }
                        }
                        break;
                }
            }
            if(map.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(map.firstKey()+" "+map.lastKey());
            }
        }
    }
}
