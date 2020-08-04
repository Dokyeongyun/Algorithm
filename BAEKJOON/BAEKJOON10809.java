package BAEKJOON;
/*
알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
 */
import java.util.Arrays;
import java.util.Scanner;

public class BAEKJOON10809 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();

        String a = "a";
        String z = "z";

        int[] arr = new int[s.length()];

        for(int i=0; i<s.length(); i++){
            for(int j = (int)a.charAt(0); j<=(int)z.charAt(0); j++){
                if(s.charAt(i)==j){
                    arr[i]=j-(int)a.charAt(0);
                }
            }
        }

        int[] arr2 = new int[(int)z.charAt(0)-(int)a.charAt(0)+1];
        Arrays.fill(arr2, -1);

        for(int i=0; i<arr2.length; i++){
            for(int j=0; j<arr.length; j++){
                if (arr[j] == i) {
                    arr2[arr[j]] = j;
                    break;
                }
            }
        }
        for(int i=0; i<arr2.length; i++){
            System.out.print(arr2[i]+ " ");
        }

    }
}
