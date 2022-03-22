package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int now = 0;

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int i = 0;

        while (count < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= now) {
                pq.offer(jobs[i++]);
            }

            if (pq.isEmpty()) {
                now = jobs[i][0];
            } else {
                int[] tmp = pq.poll();
                answer += tmp[1] + now - tmp[0];
                now += tmp[1];
                count++;
            }
        }

        return answer / jobs.length;
    }
}
