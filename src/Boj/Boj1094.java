package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1094 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int length = Integer.parseInt(br.readLine());
        int result = Integer.bitCount(length);
        System.out.println(result);
    }

}
