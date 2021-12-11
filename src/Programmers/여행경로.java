package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 여행경로 {

    public static void main(String[] args) {
        //String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        System.out.println(Arrays.toString(solution(tickets)));
    }

    static List<String> list = new ArrayList<>();
    static boolean[] check;


    private static String[] solution(String[][] tickets) {

        int len = tickets.length;
        check = new boolean[len];
        String sWord = "ICN";

        dfs(0, len, sWord, sWord, tickets);

        Collections.sort(list);

        return list.get(0).split(" ");
    }

    public static void dfs(int cnt, int len, String word, String str, String[][] tickets) {

        if (cnt == len) {
            list.add(str);
            return;
        }

        for (int j = 0; j < len; j++) {
            if (check[j]) continue;

            if (tickets[j][0].equals(word)) {
                check[j] = true;
                dfs(cnt + 1, len, tickets[j][1], str + " " + tickets[j][1], tickets);
                check[j] = false;
            }
        }
    }

}
