package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj4358 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String input;
        double cnt = 0;
        while ((input = br.readLine()) != null) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            cnt++;
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        double finalCnt = cnt;
        list.sort(Map.Entry.comparingByKey());
        list.forEach(key -> System.out.println(key.getKey() + " " + String.format("%.4f", (key.getValue() / finalCnt) * 100)));
    }
}
