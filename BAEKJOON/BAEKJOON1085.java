package BAEKJOON;

import java.util.Scanner;

/*
문제
한수는 지금 (x, y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 (0, 0)에 있고, 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 x y w h가 주어진다. w와 h는 1,000보다 작거나 같은 자연수이고, x는 1보다 크거나 같고, w-1보다 작거나 같은 자연수이고, y는 1보다 크거나 같고, h-1보다 작거나 같은 자연수이다.

출력
첫째 줄에 문제의 정답을 출력한다. */
public class BAEKJOON1085 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int w = scan.nextInt();
        int h = scan.nextInt();

        int d1 = 0;
        int d2 = 0;

        if (x > (w / 2)) {
            d1 = w - x;
        } else {
            d1 = x;
        }

        if (y > (h / 2)) {
            d2 = h - y;
        } else {
            d2 = y;
        }

        if (d1 >= d2) {
            System.out.println(d2);
        } else {
            System.out.println(d1);
        }
    }
}
