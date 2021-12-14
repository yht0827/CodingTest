package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Prim 알고리즘
 * 1) 각 Node의 간선들을 Li[] 배열에 모두 담는다.
 * 2) 정점 1부터 시작하여, Deque에 담고 시작 -> Deuque에는 항상 최대 1개의 Node만 가진다.
 * 3) Deque에서 정점을 빼며, 각 정점에 연결된 모든 간선들 중, 방문하지 않은 Node와 연결된 간선의 경우 우선순위 큐에 삽입(가중치가 작은 순서)
 * 4) 우선순위 큐가 빌때까지 최소 가중치를 가지며 방문하지 않은 Node와 연결되는 경우, 다음 Node를 Deque에 삽입하고 하던 과정을 멈춘다.
 * 5) 위의 과정 반복
 */
public class Boj1197_Prim {

    static class Info implements Comparable<Info> {

        int idx;
        long val;

        public Info(int idx, long val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Info o) {
            return Long.compare(val, o.val);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V, E;
    static boolean[] visit;
    static List<Info>[] li;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visit = new boolean[V + 1];
        li = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            li[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            li[A].add(new Info(B, C));
            li[B].add(new Info(A, C));
        }

        long result = 0;

        Queue<Info> pq = new PriorityQueue<>();
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(1);

        while (!dq.isEmpty()) {
            Integer poll = dq.poll();
            visit[poll] = true;

            for (int i = 0; i < li[poll].size(); i++) {
                int next = li[poll].get(i).idx;
                long nv = li[poll].get(i).val;
                if (!visit[next]) {
                    pq.offer(new Info(next, nv));
                }
            }
            while (!pq.isEmpty()) {
                Info info = pq.poll();

                if (!visit[info.idx]) {
                    visit[info.idx] = true;
                    dq.add(info.idx);
                    result += info.val;
                    break;
                }
            }
        }

        System.out.println(result);
    }

}
