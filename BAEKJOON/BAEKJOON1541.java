package BAEKJOON;

import java.util.Scanner;

/*
문제
세준이는 양수와 +, -, 그리고 괄호를 가지고 길이가 최대 50인 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.

출력
첫째 줄에 정답을 출력한다.
 */
public class BAEKJOON1541 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] split = scan.next().split("-");

        String[] firstArr = split[0].split("\\+");
        int first = 0;
        for (int i = 0; i < firstArr.length; i++) {
            first += Integer.parseInt(firstArr[i]);
        }

        for (int i = 1; i < split.length; i++) {
            int temp = 0;
            String[] tempArr = split[i].split("\\+");

            for (int j = 0; j < tempArr.length; j++) {
                temp += Integer.parseInt(tempArr[j]);
            }
            first -= temp;
        }

        System.out.println(first);
    }
}
