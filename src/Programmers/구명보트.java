package Programmers;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0, right = people.length - 1;
        Arrays.sort(people);

        while (left <= right) {
            if (people[left] + people[right--] <= limit) left++;
            answer++;
        }
        return answer;
    }

}
