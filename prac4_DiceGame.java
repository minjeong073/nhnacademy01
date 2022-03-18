//주사위 게임

import java.util.Random;
import java.util.Scanner;

public class prac4_DiceGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        boolean check = true;

        while (check) {
            //참가자
            System.out.print("참가할 인원을 입력하세요. > ");
            int n = sc.nextInt();
            System.out.println();

            //주사위
            System.out.print("주사위 개수를 입력하세요. > ");
            int m = sc.nextInt();
            System.out.println();
            int[][] arr = new int[n + 2][m + 1];

            int sum = 0;
            int ans = 0;    //우승자 번호
            int cnt = 0;    //우승자 중복 거르기

            for (int i = 1; i <= n; i++) {
                // m개의 random 값 배열에 넣기
                for (int j = 0; j < m; j++) {
                    arr[i][j] = random.nextInt(6) + 1;
                }
                System.out.println("참가자 " + i + " 의 주사위 눈금 ");
                for (int j = 0; j < m; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();

            }
            System.out.println("---------------------");

            for (int i = 1; i <= n; i++) {
                // m개 합 m번째 arr에 넣기
                for (int j = 0; j < m; j++) {
                    sum += arr[i][j];
                }
                arr[i][m] = sum;
                System.out.print("참가자 " + i + " 의 주사위 합 : " + arr[i][m] + " ");
                System.out.println();
                sum = 0;
            }
            
            //크기 비교하기
            int max = 0;

            for (int i = 1; i <= n; i++) {
                if (arr[i][m] > max) {
                    max = arr[i][m];
                    ans = i;
                    arr[i][m] = 0;  //최댓값인 경우 0으로 처리 
                                    // --> if문에 들어오지 않은 max와 같은 값이 존재하는지 확인
                }
            }

            for (int i = 1; i <= n; i++) {
                if (arr[i][m] == max) {
                    cnt++;
                }
            }
            
            if (cnt >0) {   //합의 최댓값이 중복되는 경우
                System.out.println();
                System.out.println("합의 최댓값이 중복되므로 다시 시작!");
                System.out.println();
            }
            else {    //합의 최댓값이 하나일 경우
                System.out.println();
                System.out.println("우승자는 " + ans + "입니다.");
                check = false;  //while문 종료
            }
        }
    }

}
