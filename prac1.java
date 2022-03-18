// 유니코드

import java.util.Scanner;

public class prac1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);

        System.out.printf("\\u%04X%n", (int) ch);
    }
}
