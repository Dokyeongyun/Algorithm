package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _2562 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = new int[9];
        int[] arr2 = new int[9];
        for(int i=0; i<9; i++){
            arr[i] = scan.nextInt();
            arr2[i] = arr[i];
        }

        Arrays.sort(arr);
        int max = arr[8];
        System.out.println(max);

        for(int i=0; i<arr.length; i++){
            if(arr2[i] == max){
                System.out.println(i+1);
                break;
            }
        }
    }
}
