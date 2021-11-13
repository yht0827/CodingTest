package Boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2475 {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(new Scanner(System.in).nextLine().split(" ")).map(s -> (int) Math.pow(Integer.parseInt(s), 2)).mapToInt(value -> value).sum() % 10);
    }
}
