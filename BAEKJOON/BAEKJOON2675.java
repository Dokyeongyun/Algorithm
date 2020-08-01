package BAEKJOON;

import java.util.Scanner;

/*
문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.

QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
 */
public class BAEKJOON2675 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int n;
        String s;
        String ss = "";
        String[] answer = new String[T];
        for (int i = 0; i < T; i++) {
            n = scan.nextInt();
            s = scan.next();
            for (int k = 0; k < s.length(); k++) {
                for (int j = 0; j < n; j++) {
                    ss += s.charAt(k);
                }
            }
            answer[i] = ss;
            ss = "";
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
