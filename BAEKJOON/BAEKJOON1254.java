package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1254
 */
public class BAEKJOON1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();

        boolean isPalindrome = isPalindrome(string);

        // 입력값이 이미 팰린드롬인 경우 => 입력문자열의 길이를 출력 후 종료
        if(isPalindrome) {
            System.out.println(string.length());
            return;
        }

        int answer = 0;
        boolean check = false;

        // 입력값이 팰린드롬이 아닌 경우
        // 앞에서부터 한문자씩 떼내면서, 나머지가 팰린드롬인지 체크,
        // 한문자씩 뗄때마다 뒤에 해당 문자를 추가하므로 최종 팰린드롬의 길이 +1
        for (int i = 0; i < string.length(); i++) {
            if (isPalindrome(string.substring(i))) {
                answer = i + string.length();
                check = true;
                break;
            }
        }

        // 최악의 경우
        if(!check) answer = string.length() * 2;

        System.out.println(answer);
    }


    // 문자열이 팰린드롬인지 체크
    static boolean isPalindrome(String string){
        int startIndex = 0;
        int endIndex = string.length()-1;
        while (startIndex <= endIndex) {
            if (string.charAt(startIndex) != string.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
