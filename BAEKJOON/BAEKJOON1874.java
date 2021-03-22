package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
문제
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지,
있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.

출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.
 */
public class BAEKJOON1874 {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static int index = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        int first = arr[0];
        for(int i=index; i<=first; i++){
            push(i);
        }
        pop();
        for(int i=1; i<N; i++){
            int temp = arr[i];
//            System.out.println("next: "+temp);
            if(stack.size()==0){
                for(int j=index; j<=temp; j++){
                    push(j);
                }
                pop();
                continue;
            }
            int top = stack.peek();
//            System.out.println("top: "+top);
            if(temp > top){
                for(int j=index; j<=temp; j++){
                    push(j);
                }
                pop();
            }else if(temp == top){
                pop();
            }else{
                System.out.println("NO");
                return;
            }

//            System.out.println(i+" "+stack.toString());
        }
        System.out.println(sb);
    }

    static void push(int num){
        stack.push(num);
        sb.append("+\n");
        index++;
    }
    static void pop(){
        stack.pop();
        sb.append("-\n");
    }

/*    static ArrayList<String> answer = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int index = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                for (int j = 1; j <= index; j++) {
                    push(j); // 1
                }
                pop(); //
            } else {
                if (arr[i - 1] > arr[i]) {
                    while (true) {
                        if (stack.peek() > arr[i]) {
                            break;
                        } else if (stack.peek() == arr[i]) {
                            pop();
                            break;
                        }
                    }
                } else {
                    for (int j = index + 1; j <= arr[i]; j++) {
                        push(j);
                    }
                    index = arr[i];
                    pop();
                }
            }
        }
        if (answer.size() == n * 2) {
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        } else {
            System.out.println("NO");
        }
    }
    public static void push(int n) {
        stack.push(n);
        answer.add("+");
    }
    public static void pop() {
        stack.pop();
        answer.add("-");
    }*/
}
