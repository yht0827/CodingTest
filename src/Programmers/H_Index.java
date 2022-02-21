package Programmers;

import java.util.Arrays;

public class H_Index {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;

        Arrays.sort(citations);

        for (int i = 0; i < n; i++) {
            int h = n - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

}
