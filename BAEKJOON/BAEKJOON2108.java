package BAEKJOON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
문제
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.
 */
public class BAEKJOON2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        System.out.println(avg(arr));
        System.out.println(middle(arr));
        System.out.println(manny(arr));
        System.out.println(range(arr));
    }

    static int avg(int[] arr) {
        double result =0;
        double sum=0;
        for(int x : arr)
            sum+=x;

        result = Math.round(sum / arr.length);
        return (int)Math.ceil(result);
    }

    static int middle(int[] arr) {
        return arr[(arr.length/2)];
    }

    static int manny(int[] arr) {
        int cnt[] = new int [8001];
        ArrayList<Integer> arrayList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int x:arr) {
            if(x<0)
                cnt[Math.abs(x)+4000]++;
            else
                cnt[x]++;
        }

        for(int i=0;i<cnt.length;i++) {
            if(cnt[i]!=0 && cnt[i]>max)
                max = cnt[i];
        }

        for(int i=0;i<cnt.length;i++) {
            int x=i;
            if(cnt[i]==max) {
                if(i>4000) {
                    x-=4000;
                    x*=-1;
                    arrayList.add(x);
                }else
                    arrayList.add(i);
            }
        }
        Collections.sort(arrayList);

        if(arrayList.size()>1) return arrayList.get(1);
        else return arrayList.get(0);
    }

    static int range(int[] arr) {
        return arr[arr.length-1] - arr[0];
    }
}
