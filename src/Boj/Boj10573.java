package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj10573 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] answer;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        answer = new long [N];

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());

            if (check(num)) {
                answer[i] = -1;
            } else {
                findNum(num, i);
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void findNum(long num, int index) {
        long cnt = 0;

        if (num < 9) {
            cnt = num;
        } else if (num > 10) {
            Queue<Long> q = new LinkedList<>();
            for (int i = 1; i <= 9; i++) {
                q.offer((long) i);
                cnt++;
            }

            while (!q.isEmpty()) {
                Long poll = q.poll();
                long temp = poll % 10;
                for (long i = temp; i <= 9; i++) {
                    if (num < poll * 10 + i) {
                        q.clear();
                        break;
                    }
                    q.offer(poll * 10 + i);
                    cnt++;
                }
            }
        }
        answer[index] = cnt;
    }

    public static boolean check(long num) {
        boolean check = false;

        String str = String.valueOf(num);

        int length = str.length();
        for (int i = 0; i < length - 1; i++) {
            if (str.charAt(i) > str.charAt(i + 1)) {
                check = true;
                break;
            }
        }
        return check;
    }
}
