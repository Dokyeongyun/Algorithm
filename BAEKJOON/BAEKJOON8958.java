package BAEKJOON;

import java.util.Scanner;

public class BAEKJOON8958 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        String[] arr = new String[T];

        for (int i = 0; i < T; i++) {
            arr[i] = scan.next();
        }

        int[] count = new int[T];
        for (int i = 0; i < arr.length; i++) {
            String[] split = arr[i].split("");
            int countTemp = 0;
            int sum = 0;

            for (int j = 0; j < split.length; j++) {
                if (j == 0) {
                    if (split[j].equals("O")) {
                        countTemp++;
                        sum += countTemp;
                    }
                } else {
                    if (split[j].equals(split[j - 1])) {
                        if (split[j].equals("O")) {
                            countTemp++;
                            sum += countTemp;
                        } else if (split[j].equals("X")) {
                            countTemp = 0;
                        }
                    } else {
                        if(split[j].equals("O")){
                            countTemp++;
                            sum+=countTemp;
                        }else{
                            countTemp = 0;
                        }
                    }
                }
                count[i] = sum;
            }
        }


        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
    }
}

