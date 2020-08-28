package BAEKJOON;

import java.util.*;

/*
문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 */
public class BAEKJOON2667 {

    static int[][] arr;
    static boolean[][] check;
    static ArrayList<Integer> countList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();


        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = scan.next().split("");
            for (int j = 0; j < row.length; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }


        check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j] && arr[i][j] == 1) {
                    // 해당 격자와 연결된 1의 값을 가지는 격자를 모두 찾아 숫자를 셈
                    bfs(i, j);
                }
            }
        }

        System.out.println(countList.size());
        Collections.sort(countList);
        for(int i=0; i<countList.size(); i++){
            System.out.println(countList.get(i));
        }
    }

    public static void bfs(int row, int col) {
        Queue<node> que = new LinkedList<>();
        int count = 0;

        que.add(new node(row, col));
        check[row][col] = true;

        while (!que.isEmpty()) {
            node temp = que.poll();
            count++;

            if (temp.col + 1 < arr.length && arr[temp.row][temp.col + 1] == 1 && !check[temp.row][temp.col + 1]) {
                que.add(new node(temp.row, temp.col + 1));
                check[temp.row][temp.col + 1] = true;
            }
            if (temp.row + 1 < arr.length && arr[temp.row + 1][temp.col] == 1 && !check[temp.row + 1][temp.col]) {
                que.add(new node(temp.row + 1, temp.col));
                check[temp.row + 1][temp.col] = true;
            }
            if (temp.col - 1 >= 0 && arr[temp.row][temp.col - 1] == 1 && !check[temp.row][temp.col - 1]) {
                que.add(new node(temp.row, temp.col - 1));
                check[temp.row][temp.col - 1] = true;
            }
            if (temp.row - 1 >= 0 && arr[temp.row - 1][temp.col] == 1 && !check[temp.row - 1][temp.col]) {
                que.add(new node(temp.row - 1, temp.col));
                check[temp.row - 1][temp.col] = true;
            }
        }

        countList.add(count);
    }

    public static class node {
        int row;
        int col;

        node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
