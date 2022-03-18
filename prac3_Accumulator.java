//사칙 연산 누적기

import java.util.Scanner;

public class prac3_Accumulator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        prac3_Accumulator accumulator = new prac3_Accumulator();
        System.out.print("어떤 연산을 하실건가요? (+,-,*,/) ");
        char ch = sc.next().charAt(0);  //연산자

        System.out.print("피연산자 숫자 2개를 입력하세요. ");
        int a = sc.nextInt();   //피연산자
        int b = sc.nextInt();   //피연산자
        int ans = 0;
        int newans = 0;
        int c = 0;

        ans = accumulator.acc(a,ch,b,ans);

        while(true) {
            System.out.println("어떤 연산을 계속 하실건가요? (+,-,*,/) (종료 : 'Q') ");
            System.out.print("> ");
            ch = sc.next().charAt(0);

            //종료
            if (ch == 'Q') {
                System.out.println("종료되었습니다.");
                break;
            }

            System.out.print("수를 입력하세요. ");
            c = sc.nextInt();

            ans = accumulator.acc(ans, ch,c,newans);
        }
    }

    private int acc(int a, char ch, int b, int answer) {
        switch (ch) {
            case '+':
                answer = a+b;
                break;
            case '-':
                answer = a-b;
                break;
            case '*':
                answer = a*b;
                break;
            case '/':
                answer = a/b;
                break;
            default:
                System.out.println();
        }
        System.out.printf("%d %c %d = %d 입니다.", a, ch, b, answer);
        System.out.println();
        return answer;
    }
}
