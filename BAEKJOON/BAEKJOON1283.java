package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.acmicpc.net/problem/1283
 */
public class BAEKJOON1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] hotKeyIndexes = new int[N];
        Arrays.fill(hotKeyIndexes, 9999);
        List<Character> hotKeys = new ArrayList<>();

        String[] words = new String[N];
        for(int i=0; i<N; i++){
            String word = br.readLine();
            words[i] = word;

            boolean check = false;
            String[] split = word.split(" ");

            int index = 0;
            for(int j=0; j<split.length; j++){
                int temp = split[j].toUpperCase().charAt(0);
//                System.out.println("temp: "+temp +" "+(char)temp);

                if(!hotKeys.contains((char)temp)){
                    hotKeys.add((char)temp);
                    hotKeyIndexes[i] = index;
                    check = true;
                    break;
                }
                index += split[j].length()+1;
            }

            if(check) continue;

            for(int j=0; j<word.length(); j++){
                char temp = word.toUpperCase().charAt(j);
                if(temp == ' ') continue;
                if(!hotKeys.contains(temp)){
                    hotKeys.add(temp);
                    hotKeyIndexes[i] = j;
                    break;
                }
            }
        }


//        System.out.println(Arrays.toString(hotKeyIndexes));
//        System.out.println(hotKeys);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length; i++){
            if(hotKeyIndexes[i] == 9999) {
                sb.append(words[i]).append("\n");
                continue;
            }
            for(int j=0; j<words[i].length(); j++){
                char word = words[i].charAt(j);
                if(j == hotKeyIndexes[i]){
                    sb.append("[").append(word).append("]");
                    continue;
                }
                sb.append(word);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
/*
8
New
Open
Save
Save As
Save All
Save All
Save All
Save All
 */