package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 복서_정렬하기 {

    public static void main(String[] args) {

        int[] weights = {60, 70, 60};
        String[] head2head = {"NNN", "NNN", "NNN"};

        System.out.println(Arrays.toString(solution(weights, head2head)));
    }

    public static int[] solution(int[] weights, String[] head2head) {
        int len = weights.length;
        int[] answer = new int[len];
        Queue<Boxer> q = new PriorityQueue<>((o1, o2) -> {

            if (o1.winRate != o2.winRate) return Double.compare(o1.winRate, o2.winRate);
            if (o1.winCount != o2.winCount) return Integer.compare(o1.winCount, o2.winCount);
            if (o1.weight != o2.weight) return Integer.compare(o1.weight, o2.weight);

            return Integer.compare(o2.index, o1.index);
        });

        for (int i = 0; i < len; i++) {
            int cnt = 0, win = 0;
            int heavy = 0;
            double rate = 0;
            for (int j = 0; j < head2head.length; j++) {
                char c = head2head[i].charAt(j);

                cnt += c == 'N' ? 0 : 1;
                win += c == 'W' ? 1 : 0;
                heavy += c == 'W' && weights[j] > weights[i] ? 1 : 0;
            }

            if (cnt != 0) rate = (double) win / cnt * 100;
            q.offer(new Boxer(i + 1, weights[i], heavy, rate));
        }

        for (int i = q.size() - 1; i >= 0; i--) {
            if (!q.isEmpty()) answer[i] = q.poll().index;
        }

        return answer;
    }

    static class Boxer {
        int index;
        int weight;
        int winCount;
        double winRate;

        public Boxer(int index, int weight, int winCount, double winRate) {
            this.index = index;
            this.weight = weight;
            this.winCount = winCount;
            this.winRate = winRate;
        }
    }
}
