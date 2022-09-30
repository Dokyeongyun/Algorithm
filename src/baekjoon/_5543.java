package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _5543 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] burger = new int[3];
        int[] soda = new int[2];
        int[] setPrice = new int[burger.length * soda.length];
        for (int i = 0; i < burger.length; i++) {
            burger[i] = scan.nextInt();
        }
        for (int i = 0; i < soda.length; i++) {
            soda[i] = scan.nextInt();
        }
        int index=0;
        for(int i=0; i<burger.length; i++){
            for(int j=0; j<soda.length; j++){
                setPrice[index] = burger[i]+soda[j]-50;
                index++;
            }
        }
        Arrays.sort(setPrice);

        System.out.println(setPrice[0]);
    }
}
