package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/*
문제
정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */
public class _10866 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            switch (temp[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(temp[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(temp[1]));
                    break;
                case "pop_front":
                    if (deque.size() != 0) {
                        bw.append(deque.removeFirst() + "\n");
                    } else {
                        bw.append("-1\n");
                    }
                    break;
                case "pop_back":
                    if (deque.size() != 0) {
                        bw.append(deque.removeLast() + "\n");
                    } else {
                        bw.append("-1\n");
                    }
                    break;
                case "size":
                    bw.append(deque.size()+"\n");
                    break;
                case "empty":
                    if(deque.size()==0){
                        bw.append("1\n");
                    }else{
                        bw.append("0\n");
                    }
                    break;
                case "front":
                    if(deque.size()==0){
                        bw.append("-1\n");
                    }else{
                        bw.append(deque.getFirst()+"\n");
                    }
                    break;
                case "back":
                    if(deque.size()==0){
                        bw.append("-1\n");
                    }else{
                        bw.append(deque.getLast()+"\n");
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();


    }
}
