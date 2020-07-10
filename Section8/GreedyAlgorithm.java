package Algorithm.Section8;

/*
        [Section8 : 탐욕 알고리즘]
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        /* *//*
            <문제1>
                A 회사의 출시 예정 스마트폰은
                현재 운영체제를 포팅하는 작업을 마무리하고 각 종 앱을 포팅하는 업무만 남았다.
                출시 전까지, 이 스마트폰의 메모리 공간에 최대한 앱을 탑재하고
                앱이 처음 실행되는 데 소요되는 시간이 얼마인지 확인하여야 한다.
                목적은 여러 가지 앱을 탑재했을 때 각각의 실행 시간이 최소가 되게 하는 것이다.

                이 때, 앱 각각은 동시에 여러 번 실행되어 메모리 공간을 차지할 수 있다.

                운영체제가 기본적으로 차지하는 메모리 크기 E,
                제공된 전체 메모리 크기 F,
                스마트폰에 포팅될 앱의 개수 N,
                앱 각각의 소요시간 배열 P,
                앱 각각의 메모리 크기 배열 W 가 주어질 때,

                이 앱들이 실행될 때 소요되는 최소 시간을 계산하라.
                (단, 사용하는 앱의 메모리 크기가 정확히 맞지 않으면 -1을 리턴하라.)
         *//*
        int E = 10;     // 운영체제가 기본적으로 차지하는 메모리 크기
        int F = 110;    // 제공된 전체 메모리 크기
        int N = 2;      // 스마트폰에 포팅될 앱 수
        int[] P = {1, 30};  // 앱을 실행하는데 소요되는 시간
        int[] W = {1, 50};  // 프로그램이 차지하는 메모리 크기

        int[] S = new int[110];

        // S의 초기 값 설정
        S[0] = 0;
        for (int i = 1; i <= F - E; i++) {
            S[i] = 9999999;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= F - E - W[i]; j++) {
                if (S[j] + P[i] < S[j + W[i]]) {
                    S[j + W[i]] = S[j] + P[i];
                }
            }
        }

        if (S[F - E] == 9999999) {
            System.out.println("-1");
        } else {
            System.out.println("스마트폰의 최소 실행시간: " + S[F - E]);
        }

        int index=0;
        for (int value : S) {
            index++;
            System.out.print("[" + value + "] ");
            if (index % 10 == 0) {
                System.out.println();
            }
        }*/

        /*
         <문제2>
            점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
            다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
            학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
            예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
            체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

            전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
            여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
            체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

               * 제한사항
              전체 학생의 수는 2명 이상 30명 이하입니다.
              체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
              여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
              여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
              여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
              이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
         */

        int ans = solution(5, new int[]{2, 4}, new int[]{1, 2, 3, 5});
        System.out.println(ans);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        // 1. lost와 reserve에 중복되는 값 제거
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }

        // 2. lost의 값 -1 또는 +1 이 reserve에 있으면 해당 원소 제거
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1)
                continue;
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                } else if (lost[i] + 1 == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }

        // 3. lost 중 -1이 아닌 값의 수 세기
        for (int value : lost) {
            if (value != -1) {
                n--;
            }
        }

        for (int value : lost) {
            System.out.print(value + " ");
        }
        System.out.println();
        for (int value : reserve) {
            System.out.print(value + " ");
        }
        System.out.println();


        return n;
    }

}
