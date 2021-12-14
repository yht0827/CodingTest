package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1922_Prim {

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<Node>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        check = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, v));
            list[e].add(new Node(s, v));
        }

        Queue<Node> pq = new PriorityQueue<>();
        Deque<Integer> dq = new ArrayDeque<>(); // 최소 크기 간선
        int result = 0;
        dq.offer(1);

        while (!dq.isEmpty()) {
            Integer poll = dq.poll();
            check[poll] = true;

            for (int i = 0; i < list[poll].size(); i++) {
                Node node = list[poll].get(i);
                if (!check[node.end]) {
                    pq.offer(new Node(node.end, node.weight));
                }
            }
            while (!pq.isEmpty()) {
                Node node = pq.poll(); // 가중치가 가장 작은 노드 순서대로

                if (!check[node.end]) {
                    check[node.end] = true;
                    dq.add(node.end);
                    result += node.weight;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
