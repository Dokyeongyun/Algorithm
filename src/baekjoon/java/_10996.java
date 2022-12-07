package baekjoon;

import java.util.Scanner;

public class _10996 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        String[][] arr = new String[2 * N][N];

        for (int i = 0; i < 2 * N; i++) {
            for (int j = 0; j < N; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    arr[i][j] = "*";
                } else if (i % 2 == 1 && j % 2 == 1) {
                    arr[i][j] = "*";
                } else if (i % 2 == 1) {
                    arr[i][j] = " ";
                } else {
                    arr[i][j] = " ";
                }
            }
        }

        if(N!=1){
            for (int i = 0; i < 2 * N; i++) {
                for (int j = 0; j < N; j++) {

                    if(!arr[i][j].equals(" ")){
                        if(i%2==0){
                            System.out.print(arr[i][j]+" ");
                        }else{
                            System.out.print(" "+arr[i][j]);
                            if(j ==N-1){
                                System.out.print(" ");
                            }
                        }
                    }
                }
                System.out.println();
            }
        }else{
            System.out.println("* ");
        }
    }
}
