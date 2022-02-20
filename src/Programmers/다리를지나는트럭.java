package Programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class 다리를지나는트럭 {

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new ArrayDeque<>();

        for (int t : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.offer(t);
                    sum += t;
                    answer++;
                    break;
                } else if (q.size() == bridge_length) {
                    sum -= q.poll();
                } else {
                    if (sum + t > weight) {
                        q.offer(0);
                        answer++;
                    } else {
                        q.offer(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }
}
