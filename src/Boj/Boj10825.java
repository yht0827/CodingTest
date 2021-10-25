package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj10825 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static PriorityQueue<Student> pq = new PriorityQueue<>();

    static class Student implements Comparable<Student> {

        String name;
        int k, e, m;

        public Student(String name, int k, int e, int m) {
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }

        @Override
        public int compareTo(Student o) {

            if (this.k > o.k) {
                return -1;
            } else if (this.k == o.k) {
                if (this.e > o.e) {
                    return 1;
                } else if (this.e == o.e) {
                    if (this.m > o.m) {
                        return -1;
                    } else if (this.m == o.m) {
                        return this.name.compareTo(o.name);
                    }
                } else {
                    return -1;
                }
            }

            return 1;
        }
    }


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            pq.offer(new Student(name, kor, eng, math));
        }

        while (!pq.isEmpty()) sb.append(pq.poll().name).append("\n");
        System.out.println(sb);
    }

}
