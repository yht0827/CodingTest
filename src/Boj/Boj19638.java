package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj19638 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while (result < T && !pq.isEmpty()) {
            if (H > pq.peek()) break;
            if (pq.peek() == 1) break;

            pq.add((int) Math.floor(pq.poll() / 2.0));
            result++;
        }

        if (!pq.isEmpty()) {
            if (pq.peek() >= H) {
                System.out.println("NO");
                System.out.println(pq.peek());
            } else {
                System.out.println("YES");
                System.out.println(result);
            }
        }
    }

}
