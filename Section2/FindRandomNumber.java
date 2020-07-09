package Algorithm.Section2;
/*
    [Section2 : 숫자 맞추기]
        1. 임의의 숫자를 생성다.
        2. 사용자로부터 키 입력을 받는다.
        3. 입력받은 값이 임의의 숫자보다 크면 크다는 메시지 출력과 다시 키 입력을 받도록,
        4. 입력받은 값이 임의의 숫자보다 작으면 작다는 메시지 출력과 다시 키 입력을 받도록,
        5. 입력받은 값이 임의의 숫자와 같으면 축하 메시지와 함께 프로그램을 종료한다.
 */


import java.util.Random;
import java.util.Scanner;

public class FindRandomNumber {
    public static void main(String[] args) {

        // << 난수 생성 >>
        // 방법1 : Math.random()
        // Math.random() 메서드의 결과 값은 0.0 과 1.0 사이의 double 값
        // 이를 정수형으로 사용하기 위해서 나눗셈 연산 또는 곱셈 연산을 수행
        System.out.println("[Math.random()을 이용한 난수 생성]");
        System.out.println("    0.0 ~ 1.0 사이 난수 생성 : " + Math.random());
        System.out.println("    1 ~ 10 사이 난수 생성 : " + (int) (Math.random() * 10));
        System.out.println("    1 ~ 100 사이 난수 생성 : " + (int) (Math.random() * 100));
        System.out.println("    1 ~ 1000 사이 난수 생성 : " + (int) (Math.random() * 1000));

        // 방법2 : Random 클래스 이용
        // Random 클래스는 Java.util 패키지 내에 정의 -> import 필요
        // new 연산자를 통해 객체를 생성하면 디폴트 시드값이 현재 시간으로 설정되며
        // setSeed 메서드를 통하여 시드값을 설정해줄 수 있다.

        // Random 클래스의 난수 생성 메서드는 다음과 같다.
        // nextBoolean(), nextDouble(), nextInt()
        // nextInt(int n), nextGaussian()

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        System.out.println("[Random 클래스를 이용한 난수 생성]");
        System.out.println("    nextBoolean() 을 이용한 난수 생성 : " + random.nextBoolean());
        System.out.println("    nextDouble() 을 이용한 난수 생성 : " + random.nextDouble());
        System.out.println("    nextInt() 을 이용한 난수 생성 : " + random.nextInt());
        System.out.println("    nextInt(int n) 을 이용한 특정 범위 내 난수 생성 : " + random.nextInt(10));
        System.out.println("    nextGaussian() 을 이용한 난수 생성 : " + random.nextGaussian());

        int ran = random.nextInt(1000);
        System.out.println("[숫자 맞추기 프로그램]");
        System.out.println("0부터 1000까지의 숫자를 입력하시오.");

        Scanner scan = new Scanner(System.in);
        int input = 0;

        int index = 1;
        while (input != ran) {
            System.out.print("[" + index + "번째 도전] : ");
            input = scan.nextInt();

            if (input > ran) {
                System.out.println(input + " 보다 작습니다.");
            } else if (input < ran) {
                System.out.println(input + " 보다 큽니다.");
            } else {
                System.out.println("정답입니다!");
                break;
            }
            index++;
        }
    }
}
