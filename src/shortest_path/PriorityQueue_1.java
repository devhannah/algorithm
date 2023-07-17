package shortest_path;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/***
 * 우선순위가 가장 높은 데이터를 가장 먼저 삭제하는 자료구조
 * 예를 들어 여러 개의 물건 데이터를 자료구조에 넣었다가 가치가 높은 물건 데이터부터 꺼내서 확인해야 하는 경우
 * 우선순위 큐를 이용할 수 있다
 *
 * Heap
 * 우선순위 큐를 구현하기 위해 사용하는 자료구조 중 하나
 * 최소 힙과 최대 힙이 있음
 * (min heap) (max heap)
 *
 * 다익스트라 최단 경로 알고리즘을 포함해 다양한 알고리즘에서 사용됨
 * 우선순위 큐 구현 방식 | 삽입 시간 | 삭제 시간
 *      리스트           O(1)      O(N)
 *     힙(Heap)       O(logN)   O(logN)
 *
 * 단계마다 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 '선택하기 위해' 힙(heap) 자료구조를 이용
 * 다익스트라 알고리즘이 동작하는 기본 원리는 동일
 * - 현재 가장 가까운 노드를 '저장해 놓기 위해서' 힙 자료구조를 추가적으로 이용한다는 점이 다름
 * - 현재의 최단 거리가 가장 짧은 노드를 선택해야 하므로 최소 힙을 사용
 */

class Node2 implements Comparable<Node2> {

    private int index;
    private int distance;

    public Node2(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node2 other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class PriorityQueue_1 {

    public static final int INF = (int)1e9;
    public static int N, M, START;
    public static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();
    public static int[] d = new int[100001];

    public static void dijkstra(int START) {
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정해서 큐에 삽입
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        pq.offer(new Node2(0, START));
        d[START] = 0;
        while (!pq.isEmpty()) {
            // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node2 node = pq.poll();
            int dist = node.getDistance();
            // 현재 노드까지의 비용
            int now = node.getIndex();
            // 현재 노드
            // 만약 현재 노드가 이미 처리된 적이 있다면? -> 무시
            if (d[now] < dist) {
                continue;
            }
            // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node2(graph.get(now).get(i).getIndex(), cost));
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
            graph.add(new ArrayList<Node2>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node2(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(START);

        for (int i = 1; i <= N ; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }


    }

}
