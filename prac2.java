// 명함 출력하기

import java.util.Scanner;
/*
input name: hong gildong
input email: gildong.hong@nhn.com
input mobile: 010-1111-2222
OK

  name:         hong gildong
 email: gildong.hong@nhn.com
mobile:        010-1111-2222
 */
public class prac2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = "name";
        String e = "email";
        String m = "mobile";
        System.out.print("name > ");
        String name = sc.nextLine();
        System.out.print("email > ");
        String email = sc.nextLine();
        System.out.print("mobile > ");
        String mobile = sc.nextLine();
        System.out.println("OK");

        System.out.printf("%6s: %20s%n", n, name);
        System.out.printf("%6s: %20s%n", e, email);
        System.out.printf("%6s: %20s%n", m, mobile);
    }
}
