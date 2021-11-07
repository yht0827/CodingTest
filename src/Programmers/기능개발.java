package Programmers;

import java.util.*;

public class 기능개발 {

    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int num = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) num += 1;

            q.add(num);
        }


        int cnt = 1;
        int top = q.poll();

        while (!q.isEmpty()) {
            int num = q.poll();

            if (top >= num) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                top = num;
            }
        }

        list.add(cnt);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
