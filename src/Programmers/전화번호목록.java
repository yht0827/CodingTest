package Programmers;

import java.util.Arrays;

public class 전화번호목록 {

    public static void main(String[] args) {

        String[] phone_book = {"2", "32"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        int len = phone_book.length;

        Arrays.sort(phone_book);

        for (int i = 0; i < len - 1; i++) {
            if (phone_book[i + 1].indexOf(phone_book[i]) == 0) {
                answer = false;
                break;
            }
        }

        return answer;
    }

}
