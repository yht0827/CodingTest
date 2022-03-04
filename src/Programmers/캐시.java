package Programmers;

import java.util.Deque;
import java.util.LinkedList;

public class 캐시 {

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;
        Deque<String> cache = new LinkedList<>();

        for (String city : cities) {
            String str = city.toLowerCase();

            // cache hit
            if (cache.remove(str)) {
                cache.addFirst(str);
                answer += 1;
            } else { // cache miss
                if (cache.size() == cacheSize) {
                    cache.pollLast();
                }
                cache.addFirst(str);
                answer += 5;
            }
        }

        return answer;
    }

}
