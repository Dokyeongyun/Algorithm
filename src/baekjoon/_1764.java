package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
문제
김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
이름은 띄어쓰기 없이 영어 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.

출력
듣보잡의 수와 그 명단을 사전순으로 출력한다.
 */
public class _1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] nonHear = new String[n];
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            nonHear[i] = br.readLine();
        }
        Arrays.sort(nonHear);

        for(int i=0; i<m; i++){
            String temp = br.readLine();

            int min = 0;
            int max = nonHear.length-1;
            int mid;
            while(true){
                if(min>max){
                    break;
                }
                mid = (min+max)/2;

                if(nonHear[mid].equals(temp)){
                    list.add(temp);
                    break;
                }else{
                    String first = compare(nonHear[mid], temp);
                    if(first.equals(temp)){
                        max = mid-1;
                    }else{
                        min = mid+1;
                    }
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static String compare(String s1, String s2){
        String[] arr = new String[2];
        arr[0] = s1;
        arr[1] = s2;
        Arrays.sort(arr);

        return arr[0];
    }
}

