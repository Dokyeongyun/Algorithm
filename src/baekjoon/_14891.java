package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14891
 */
public class _14891 {

    static final int numberOfCogWheelTeeth = 8;
    static final int numberOfGears = 4;
    static final int leftTeethIndex = 6;
    static final int rightTeethIndex = 2;
    static final int NORTH_POLE = 1;
    static final int SOUTH_POLE = -1;

    static int[][] gears;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        gears = new int[numberOfGears][numberOfCogWheelTeeth];
        for (int i = 0; i < numberOfGears; i++) {
            String s = br.readLine();
            for (int j = 0; j < numberOfCogWheelTeeth; j++) {
                gears[i][j] = s.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gearId = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            rotate(gearId, direction);
        }

        int point = 0;
        for (int i = 0; i < numberOfGears; i++) {
            point += gears[i][0] == 0 ? 0 : Math.pow(2, i);
        }
        System.out.println(point);
    }

    static void rotate(int gearId, int direction) {
        int[] directions = new int[numberOfGears];
        directions[gearId] = direction;

        for (int i = gearId - 1; i >= 0; i--) {
            if (gears[i][rightTeethIndex] != gears[i + 1][leftTeethIndex]) {
                directions[i] = directions[i + 1] * -1;
            } else {
                break;
            }
        }
        for (int i = gearId + 1; i < numberOfGears; i++) {
            if (gears[i][leftTeethIndex] != gears[i - 1][rightTeethIndex]) {
                directions[i] = directions[i - 1] * -1;
            } else {
                break;
            }
        }

        int temp;
        for (int i = 0; i < numberOfGears; i++) {
            if (directions[i] == NORTH_POLE) {
                temp = gears[i][numberOfCogWheelTeeth - 1];
                for (int j = numberOfCogWheelTeeth - 1; j > 0; j--) {
                    gears[i][j] = gears[i][j - 1];
                }
                gears[i][0] = temp;
            }

            if (directions[i] == SOUTH_POLE) {
                temp = gears[i][0];
                for (int j = 0; j < numberOfCogWheelTeeth - 1; j++) {
                    gears[i][j] = gears[i][j + 1];
                }
                gears[i][numberOfCogWheelTeeth - 1] = temp;
            }
        }

    }

}
