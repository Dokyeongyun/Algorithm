package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class BAEKJOON3052 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = new int[10];
        for(int i=0; i<10; i++){
            arr[i] = scan.nextInt()%42;
        }

        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }

        int count=1;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] != arr[i+1]){
                count++;
            }
        }
        System.out.println(count);
    }
}
