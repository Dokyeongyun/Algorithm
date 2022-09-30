package baekjoon;

import java.util.Scanner;

public class _2446 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int[][] arr = new int[N][3];
        int k=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                if(j==1){
                    arr[i][j] = 2*N-1-k;
                    k = k+2;
                }else{
                    arr[i][j] =i;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j = 0; j<arr[i][0]; j++){
                System.out.print(" ");
            }
            for(int l=0; l<arr[i][1]; l++){
                System.out.print("*");
            }
            System.out.print(" ");
            System.out.println();
        }

        for(int i=N-1; i>0; i--){
            for(int j = 0; j<arr[i-1][0]; j++){
                System.out.print(" ");
            }
            for(int l=0; l<arr[i-1][1]; l++){
                System.out.print("*");
            }
            System.out.print(" ");
            System.out.println();
        }
    }

    /*
     *********
     *******
     *****
     ***
     *
     ***
     *****
     *******
     *********
     */
}
