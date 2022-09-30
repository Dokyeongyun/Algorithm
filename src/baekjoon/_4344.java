package baekjoon;

import java.util.Scanner;

public class _4344 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        double[] ratio = new double[T];

        for(int i=0; i<T; i++){
            int n = scan.nextInt();
            int[] score = new int[n];
            int sum=0;
            int count = 0;

            for(int j=0; j<n; j++){
                score[j] = scan.nextInt();
                sum+=score[j];
            }
            for(int k=0; k<n; k++){
                if(score[k]>(sum/n)){
                    count++;
                }
            }
            ratio[i] = Math.round(count/(double)n * 100000)/(double)1000;
        }

        for(int i=0; i<ratio.length; i++){
            System.out.printf("%.3f", ratio[i]);
            System.out.print("%\n");
        }
    }
}

