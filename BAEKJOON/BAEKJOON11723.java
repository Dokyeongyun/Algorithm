package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.

add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다.
입력
첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.

둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.

출력
check 연산이 주어질때마다, 결과를 출력한다.
 */
public class BAEKJOON11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[20+1];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String opr = st.nextToken();
            int x = 0;
            if (!opr.equals("all") && !opr.equals("empty")){
                x = Integer.parseInt(st.nextToken());
            }

            switch (opr){
                case "add":
                    if(arr[x]==0){
                        arr[x] = 1;
                    }
                    break;
                case "remove":
                    if(arr[x]==1){
                        arr[x] = 0;
                    }
                    break;
                case "check":
                    sb.append(arr[x]).append("\n");
                    break;
                case "toggle":
                    if(arr[x]==1){
                        arr[x]=0;
                    }else{
                        arr[x]=1;
                    }
                    break;
                case "all":
                    for(int j=1; j<=20; j++){
                        arr[j] = 1;
                    }
                    break;
                case "empty":
                    for(int j=1; j<=20; j++){
                        arr[j] = 0;
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
