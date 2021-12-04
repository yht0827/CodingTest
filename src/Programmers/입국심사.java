package Programmers;

import java.util.Arrays;

public class 입국심사 {

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        System.out.println(solution(n, times));
    }

    private static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long left = 0;
        long right = (long) n * times[times.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0; // 총 심사 인원

            for (int time : times) {
                sum += mid / time;
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }


        return answer;
    }
}
