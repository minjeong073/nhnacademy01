//가위바위보 게임

import java.util.Random;
import java.util.Scanner;

public class prac5_RSPGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        while(check) {
            System.out.print("가위(1), 바위(2), 보(3) : ");
            int rsp = sc.nextInt();

            switch (rsp) {
                case 1:
                    System.out.println("당신은 가위(1)입니다.");
                    break;
                case 2:
                    System.out.println("당신은 바위(2)입니다.");
                    break;
                case 3:
                    System.out.println("당신은 보(3)입니다.");
                    break;
                default:
                    System.out.println("잘못된 입력!");
            }

            Random random = new Random();
            int com_rsp = random.nextInt(3) + 1;

            switch (com_rsp) {
                case 1:
                    System.out.println("컴퓨터는 가위(1)입니다.");
                    break;
                case 2:
                    System.out.println("컴퓨터는 바위(2)입니다.");
                    break;
                case 3:
                    System.out.println("컴퓨터는 보(3)입니다.");
                    break;
            }

            if (rsp == com_rsp) {
                System.out.println("비겼습니다. 다시 시작합니다. ");
                System.out.println();
                check = true;
            } else if (rsp < com_rsp){
                System.out.println("졌습니다..");
            } else {
                System.out.println("이겼습니다!");
            }
        }

    }
}
