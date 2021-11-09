package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2075 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) pq.offer(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while (N-- > 0 && !pq.isEmpty()) {
            result = pq.poll();
        }

        System.out.println(result);
    }
}
