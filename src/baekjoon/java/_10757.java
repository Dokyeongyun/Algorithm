package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int index1 = split[0].length()-1;
        int index2 = split[1].length()-1;

        int remainder = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {

            int tmp1 = index1 >= 0 ? Integer.parseInt(String.valueOf(split[0].charAt(index1))) : 0;
            int tmp2 = index2 >= 0 ? Integer.parseInt(String.valueOf(split[1].charAt(index2))) : 0;


            int tmpSum = tmp1 + tmp2 + remainder;
            int current = tmpSum % 10;
            remainder = tmpSum / 10;

            index1--;
            index2--;
            sb.insert(0, current);
        }
        if(remainder > 0) {
            sb.insert(0, remainder);
        }
        System.out.println(sb);



    }
}
