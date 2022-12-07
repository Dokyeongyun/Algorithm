package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1052 {
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2의 제곱수이면 0개
        // K가 N보다 크면 0개
        if(isSquareNum(N) || N <= K){
            System.out.println(0);
            return;
        }

        // 최초 주어진 물병으로 줄일 수 있는 최소 개수 구하기
        count = new int[26];
        int index = 0;

        count[0] = N;
        int tempCount = N;

        while(true){
            if(tempCount <= K) {
                System.out.println(0);
                return;
            }
            if(count[index]/2 == 0) break;

            tempCount -= count[index];
            count[index+1] = count[index]/2;
            count[index] = count[index]%2;
            tempCount += count[index+1] + count[index];
            index++;
//            System.out.println(Arrays.toString(count));
//            System.out.println(tempCount);
        }
//        System.out.println("최대 "+Arrays.toString(count));

        int buyCount = 0;
        int diff = tempCount - K;
//        System.out.println(diff);

        for(int i=0; i<count.length; i++){
            if(count[i] == 1){
                buyCount += Math.pow(2, i);
                count[i] = 0;
                count[i+1]++;
                int tempIndex = i;
                while(true){
                    if(count[tempIndex+1] == 2){
                        count[tempIndex+1] = 0;
                        count[tempIndex+2]++;
                        tempIndex++;
                    }else{
                        break;
                    }
                }
            }
            if(arrCount() <= K) break;
        }
//        System.out.println("답: "+buyCount);

        System.out.println(buyCount);
    }

    static int arrCount(){
        int temp = 0;
        for (int j : count) {
            temp += j;
        }
        return temp;
    }
    static boolean isSquareNum(int num){
        int i = 1;
        while(true){
            int squareNum = (int) Math.pow(2, i);
            if(num == squareNum) return true;
            if(num < squareNum) return false;
            i++;
        }
    }
}
