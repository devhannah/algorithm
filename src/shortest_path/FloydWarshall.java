package shortest_path;

import java.util.Arrays;
import java.util.Scanner;

/***
 * 모든 노드에서 다른 모든 노드까지의 최단 경로를 모두 계산
 * 플로이드 워셜 알고리즘은 다익스트라 알고리즘과 마찬가지로 단계별로 거쳐 가는 노드를 기준으로 알고리즘 수행
 * 다만 매 단계마다 방문하지 않은 노드 중에 최단 거리를 갖는 노드를 찾는 과정이 필요하지 않음
 * 플로이드 워셜은 2차원 테이블에 최단 거리 정보를 저장함
 * 플로이드 워셜 알고리즘은 다이나믹 프로그래밍 유형에 속함
 *
 * 시간복잡도가 O(N^3)
 *
 * 각 단계마다 특정한 노드 k를 거쳐 가는 경우를 확인
 * a에서 b로 가는 최단 거리보다 a에서 k를 거쳐 b로 가는 거리가 더 짧은지 검사해야 함
 * Dab = min(Dab, Dak + Dkb)
 */
public class FloydWarshall {

    public static final int INF = (int)1e9;
    public static int N, M;
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= M; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        // 점화식에 따라 플로이드 워셜 알고리즘 수행
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a < N; a++) {
                for (int b = 1; b < N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력
        for (int a = 1; a <= N ; a++) {
            for (int b = 1; b <= N; b++) {
                // 도달할 수 없는 경우
                if (graph[a][b] == INF) {
                    System.out.println("INFINITY");
                } else {
                    System.out.println(graph[a][b]);
                }
            }
        }
    }

}
