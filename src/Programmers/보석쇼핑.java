package Programmers;

import java.util.*;

public class 보석쇼핑 {

    public static void main(String[] args) {

        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
    }

    public static int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 0, len = gems.length;
        int start = 0, end = 0, distance = Integer.MAX_VALUE;

        while (true) {

            if (set.size() == map.size()) {
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else if (right == len) {
                break;
            } else {
                map.put(gems[right], map.getOrDefault(gems[right++], 0) + 1);
            }

            if (set.size() == map.size()) {
                if (right - left < distance) {
                    distance = right - left;
                    start = left + 1;
                    end = right;
                }
            }
        }

        return new int[]{start, end};
    }
}
