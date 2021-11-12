package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj15903 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static List<Lec> list = new ArrayList<>();
    static Queue<Lec> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

    static class Lec {
        int start, end;

        public Lec(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Lec(start, end));
        }

        list.sort((o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
        pq.offer(list.get(0));

        for (int i = 1; i < list.size() && !pq.isEmpty(); i++) {
            Lec peek = pq.peek();

            if (peek.end <= list.get(i).start) {
                pq.poll();
            }
            pq.offer(list.get(i));
        }

        System.out.println(pq.size());
    }

}
