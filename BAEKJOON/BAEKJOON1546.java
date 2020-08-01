package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class BAEKJOON1546 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<arr.length; i++){
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);
        double max = arr[arr.length-1];

        double[] arr2 = new double[N];
        double sum=0;
        for(int i=0; i<arr2.length; i++){
            arr2[i] = arr[i]/max*100;
            sum+=arr2[i];
        }
        System.out.println(sum/N);
    }
}
