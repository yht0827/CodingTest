package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11656 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int len = str.length();

        for (int i = 0; i < len; i++) list.add(str.substring(i));

        list.sort(String::compareTo);

        for (String s : list) System.out.println(s);
    }
}
