import java.util.Arrays;
import java.util.Random;

public class prac6_LottoGame {

    public static void main(String[] args) {

        boolean check = true;
        System.out.println("로또 번호를 추첨합니다.");
        Random random = new Random();
        int[] arr = new int[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = random.nextInt(45) + 1;
            //중복 확인
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) { //i 이전의 값과 비교해서 같은 값이 있을 경우 i-- 다시 뽑기
                    i--;
                    break;
                }
            }
        }
        System.out.print(Arrays.toString(arr));
    }
}