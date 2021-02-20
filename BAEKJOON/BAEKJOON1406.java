package BAEKJOON;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEKJOON1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        // Stack 이용하여 구현
        // 커서 왼쪽의 문자 담는 Stack과 커서 오른쪽의 문자 담는 Stack
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        // 초기 문자열 leftStack에 담기
        for(int i=0; i<s.length(); i++){
            leftStack.push(s.charAt(i));
        }

        // 에디터 명령에 따라 작업 처리
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "L": // 커서를 왼쪽으로 한 칸
                    if(leftStack.size()!=0) rightStack.push(leftStack.pop());
                    break;
                case "D": // 커서를 오른쪽으로 한 칸
                    if(rightStack.size()!=0) leftStack.push(rightStack.pop());
                    break;
                case "B": // 커서 왼쪽에 있는 문자 하나 삭제
                    if(leftStack.size()!=0) leftStack.pop();
                    break;
                case "P": // 다음 입력문자 하나를 커서 왼쪽에 추가
                    leftStack.push(st.nextToken().charAt(0));
                    break;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
        while (!rightStack.isEmpty()) bw.append(rightStack.pop());

        bw.flush();
    }
}
