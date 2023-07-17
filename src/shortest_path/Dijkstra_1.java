package shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/***
 * [전보 문제]
 * 핵심 아이디어 : 한 도시에서 다른 도시까지의 최단 거리를 구하는 문제
 * N과 M의 범위가 충분히 크기 때문에 우선순위 큐를 활용한 다익스트라 알고리즘으로 구현하면 됨
 */

class NodeDijkstra implements Comparable<NodeDijkstra>{

    private int index;
    private int distance;

    public NodeDijkstra(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(NodeDijkstra o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}
public class Dijkstra_1 {

    public static final int INF = (int)1e9;
    public static int N, M, START;
    public static ArrayList<ArrayList<NodeDijkstra>> graph = new ArrayList<ArrayList<NodeDijkstra>>();
    public static int[] d = new int[30001];

    public static void dijkstra(int START) {
        PriorityQueue<NodeDijkstra> pq = new PriorityQueue<>();
        pq.offer(new NodeDijkstra(START, 0));
        d[START] = 0;

        while (!pq.isEmpty()) {
            NodeDijkstra node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();
            if (d[now] < dist) {
                continue;
            }
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new NodeDijkstra(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        START = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<NodeDijkstra>());
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new NodeDijkstra(y, z));
        }

        Arrays.fill(d, INF);

        dijkstra(START);

        // 도달할 수 있는 노드의 개수
        int count = 0;
        // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
        int maxDistance = 0;

        for (int i = 1; i <= N; i++) {
            if (d[i] != INF) {
                count += 1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        // 시작 노드는 제외해야 하므로 count - 1 출력
        System.out.println((count - 1) + " " + maxDistance);

    }

}
