package shortest_path;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra_2 {

    public static final int INF = (int)1e9;
    public static int N, M, X, K;
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= M; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력 받아서 그 값으로 초기화
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // A와 B가 서로에게 가는 비용은 1이라고 설정
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        X = sc.nextInt();
        K = sc.nextInt();

        // 점화식에 따라 플로이드 워셜 알고리즘 수행
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N ; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int distance = graph[1][K] + graph[K][X];

        if (distance >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(distance);
        }

    }

}
