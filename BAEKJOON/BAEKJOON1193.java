package BAEKJOON;

import java.util.Scanner;

/*
문제
무한히 큰 배열에 다음과 같이 분수들이 적혀있다.

1/1	1/2	1/3	1/4	1/5	…
2/1	2/2	2/3	2/4	…	…
3/1	3/2	3/3	…	…	…
4/1	4/2	…	…	…	…
5/1	…	…	…	…	…
…	…	…	…	…	…
이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.

출력
첫째 줄에 분수를 출력한다.
 */
public class BAEKJOON1193 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int X = scan.nextInt();

        int top = 0;
        int highest = 1;
        boolean check = false;
        int index = 0;

        while (true) {
            top = 0;
            for (int j = 0; j < highest * 2 - 1; j++) {
                if (j >= highest) {
                    top--;
                } else {
                    top++;
                }
                index++;
                if (index == X) {
                    check = true;
                    break;
                }
            }
            highest += 2;
            if(check){
                break;
            }
        }

        int bottom = 0;
        highest = 2;
        index = 0;
        check = false;

        while (true) {
            bottom = 0;
            for (int j = 0; j < highest * 2 - 1; j++) {
                if (j >= highest) {
                    bottom--;
                } else {
                    bottom++;
                }
                index++;
                if (index == X) {
                    check = true;
                    break;
                }
            }
            highest += 2;
            if(check){
                break;
            }
        }

        System.out.println(top+"/"+bottom);
    }
}
