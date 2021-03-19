package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON1195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String gear1 = br.readLine();
        String gear2 = br.readLine();

        int length = gear1.length() + gear2.length();
        for(int i=gear2.length()*-1; i<= gear1.length(); i++){
            boolean exit = true;
            for(int j=0; j<gear1.length(); j++){
                int temp = 0;
                if(j-i >= 0 && j-i < gear2.length()) {
                    temp = gear2.charAt(j-i);
                }
//                System.out.println("======================================");
//                System.out.println("i: "+i+ " // j: "+j);
//                System.out.println("temp: "+temp +" // gear1.charAt(j): "+gear1.charAt(j));
//                System.out.println(temp + gear1.charAt(j)-'0'-'0');
//                System.out.println(temp + gear1.charAt(j));
                exit &= temp + gear1.charAt(j)-'0'-'0' <= 3;
//                System.out.println(exit);
//                System.out.println("======================================");
            }
            if(exit){
                length = Math.min(length, Math.max(i + gear2.length(), gear1.length()) - Math.min(i, 0));
//                System.out.println(length);
            }
        }

        System.out.println(length);
    }
}
