package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1713
 */
public class _1713 {

    static Map<Integer, Candidate> candidates = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
/*
3
9
2 2 4 3 5 6 2 7 2
 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int tempNum = Integer.parseInt(st.nextToken());

            // 사용할 수 있는 사진틀이 남아있으면
            if(candidates.size() < N){
                // 현재 사진틀에 걸려있지 않은 후보이면 => 후보를 사진틀에 추가
                if(!candidates.containsKey(tempNum)){
                    candidates.put(tempNum, new Candidate(1, i));
                }else{ // 현재 사진틀에 걸려있는 후보이면 => 추천수 +1
                    Candidate temp = candidates.get(tempNum);
                    candidates.put(tempNum, new Candidate(temp.recommendCount+1, temp.time));
                }
            }else{ // 사진틀이 가득 차있으면
                // 현재 사진틀에 걸려있는 후보이면 => 추천수 +1
                if(candidates.containsKey(tempNum)){
                    Candidate temp = candidates.get(tempNum);
                    candidates.put(tempNum, new Candidate(temp.recommendCount+1, temp.time));
                }else{ // 현재 사진틀에 걸려있지 않은 후보이면 =>
                        // 추천수가 가장 적거나, 추가시간이 가장 빠른 후보 제거
                        // 그리고 새로운 후보 추가
                    candidates.remove(getRemoveCandidate());
                    candidates.put(tempNum, new Candidate(1, i));
                }
            }
        }

        List<Integer> keyList = new ArrayList<>(candidates.keySet());

        // 정렬
        Collections.sort(keyList);

        // 출력
        for (Integer integer : keyList) System.out.print(integer + " ");

    }

    static int getRemoveCandidate(){
        int removeCandidateNum = 0;

        List<Candidate> list = new ArrayList<>(candidates.values());
        Collections.sort(list);

        Candidate removeCan = list.get(0);

        for(Integer key : candidates.keySet()){
            Candidate temp = candidates.get(key);
            if(temp == removeCan){
                removeCandidateNum = key;
            }
        }

        return removeCandidateNum;
    }

    static class Candidate implements Comparable<Candidate>{
        int recommendCount;
        int time;
        Candidate(int recommendCount, int time){
            this.recommendCount = recommendCount;
            this.time = time;
        }

        @Override
        public int compareTo(Candidate o) {
            if(recommendCount < o.recommendCount){
                return -1;
            }else if(recommendCount > o.recommendCount){
                return 1;
            }else{
                if(time < o.time){
                    return -1;
                }else if(time > o.time){
                    return 1;
                }
            }
            return 0;
        }

        @Override
        public String toString() {
            return recommendCount+" "+time;
        }
    }
}
