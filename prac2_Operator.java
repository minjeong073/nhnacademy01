//사칙연산기

import java.util.Scanner;

public class prac2_Operator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;
        System.out.print("어떤 연산을 하실건가요? (+,-,*,/) ");
        ch = sc.next().charAt(0);

        System.out.print("피연산자 숫자 2개를 입력하세요. ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = 0;

        switch (ch) {
            case '+':
               ans = a+b;
               break;
            case '-':
                ans = a-b;
                break;
            case '*':
                ans = a*b;
                break;
            case '/':
                ans = a/b;
                break;
            default:
                System.out.println();
        }

        System.out.printf("%d %c %d = %d 입니다.", a, ch, b, ans);
    }
}
