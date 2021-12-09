package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11657 {

    static class Node {
        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, INF = Integer.MAX_VALUE;
    static Node[] node;
    static long[] dist;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        node = new Node[M + 1];
        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            node[i] = new Node(a, b, c);
        }

        if (bellmanFord()) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                System.out.println(dist[i] == INF ? -1 : dist[i]);
            }
        }
    }

    private static boolean bellmanFord() {
        dist[1] = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = 1; j <= M; j++) {
                if (dist[node[j].start] != INF && dist[node[j].end] > dist[node[j].start] + node[j].weight) {
                    dist[node[j].end] = dist[node[j].start] + node[j].weight;
                }
            }
        }

        // 음수 사이클
        for (int i = 1; i <= M; i++) {
            if (dist[node[i].start] != INF && dist[node[i].end] > dist[node[i].start] + node[i].weight) {
                return true;
            }
        }

        return false;
    }

}
