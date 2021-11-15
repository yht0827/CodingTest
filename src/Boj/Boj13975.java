package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13975 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Queue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            long sum = 0;
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) pq.offer(Long.parseLong(st.nextToken()));

            while (pq.size() > 1) {
                long temp = pq.poll() + pq.poll();
                sum += temp;
                pq.offer(temp);
            }
            sb.append(sum).append("\n");
            pq.clear();
        }

        System.out.println(sb);
    }
}
