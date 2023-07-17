package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** 모험가 길드 문제
 *
 * 한 마을에 모험가가 N명 있습니다. 모험가 길드에서는 N명의 모험가를 대상으로 '공포도'를 측정했는데,
 * '공포도'가 높은 모험가는 쉽게 공포를 느껴 위험 상황에서 제대로 대처할 능력이 떨어집니다.
 *
 * 모험가 길드장인 동빈이는 모험가 그룹을 안전하게 구성하고자 공포도가 X인 모험가는 반드시 X명 이상으로
 * 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있도로 규정했습니다.
 *
 * 동빈이는 최대 몇 개의 모험가 그룹을 만들 수 있는지 궁금합니다. N명의 모험가에 대한 정보가 주어졌을 때,
 * 여행을 떠날 수 있는 그룹 수의 최댓값을 구하는 프로그램을 작성하세요.
 *
 **/


public class Greedy_3 {

    public static int N;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // 내가 푼 방법

        /*
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            data[i] = M;
        }
        Arrays.sort(data);
        */

        /* 쌤이 푼 방법 */
        for (int i = 0; i < N; i++) {
            arrayList.add(sc.nextInt());
        }
        Collections.sort(arrayList);

        int result = 0; // 총 그룹의 수
        int count = 0; // 현재 그룹에 포함된 모험가의 수

        for (int i = 0; i < N; i++) { // 공포도를 낮은 것부터 하나씩 확인하며
            count += 1; // 현재 그룹에 해당 모험가를 포함시키기
            if (count >= arrayList.get(i)) { // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
                result += 1; // 총 그룹의 수 증가시키기
                count = 0; // 현재 그룹에 포함된 모험가의 수 초기화
            }
        }

        System.out.println(result);

    }

}
