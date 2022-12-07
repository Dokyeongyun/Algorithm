package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
 출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */
public class _1157 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        String[] arr = input.toUpperCase().split("");
        ArrayList<String> list = new ArrayList<>();

        // 중복제거
        for (String s : arr) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }

        int[] count = new int[list.size()];

        // 각 문자 수 count
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (arr[i].equals(list.get(j))) {
                    count[j]++;
                    break;
                }
            }
        }

        int max = count[0];
        int maxIndex = 0;

        for (int i = 0; i < count.length - 1; i++) {
            if (max < count[i + 1]) {
                max = count[i + 1];
                maxIndex = i + 1;
            }
        }

        Arrays.sort(count);

        if (count.length != 1) {
            if (count[count.length - 1] == count[count.length - 2]) {
                System.out.println("?");
            } else {
                System.out.println(list.get(maxIndex));
            }
        }else{
            System.out.println(list.get(maxIndex));
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
        System.out.println();

        System.out.println(list);
    }
}
