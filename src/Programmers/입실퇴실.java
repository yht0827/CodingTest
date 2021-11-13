package Programmers;

import java.util.*;

public class 입실퇴실 {

    public static void main(String[] args) {

        int[][] enter = {{1, 3, 2}, {1, 4, 2, 3}, {3, 2, 1}, {3, 2, 1}, {1, 4, 2, 3}};
        int[][] leave = {{1, 2, 3}, {2, 1, 3, 4}, {2, 1, 3}, {1, 3, 2}, {2, 1, 4, 3}};

        // [0,1,1], [2,2,1,3], [1,1,2], [2,2,2], [2,2,0,2]
        for (int i = 0; i < enter.length; i++) System.out.println(Arrays.toString(solution(enter[i], leave[i])));
    }

    private static int[] solution(int[] enter, int[] leave) {
        int len = enter.length;
        int[] answer = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;

        for (int j : enter) {
            map.put(j, 0);
            for (int key : map.keySet()) {
                if (key == j) answer[key-1] = map.size()-1;
                else answer[key-1]++;
            }

            while (idx < len && map.containsKey(leave[idx])) {
                map.remove(leave[idx++]);
            }
        }


        return answer;
    }

}
