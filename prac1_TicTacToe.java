import java.util.Random;
import java.util.Scanner;

public class prac1_TicTacToe {
    static char[][] board = new char[3][3];
    static int comx, comy;
    static int user = 0;   //사용자 빙고 확인
    static int com = 0;    //컴퓨터 빙고 확인

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        prac1_TicTacToe t = new prac1_TicTacToe();
        boolean check = true;
        int count = 0;

        for (int i=0; i< board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        do {
            //사용자 입력
            System.out.print("좌표를 입력하세요. > ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println();

            //비어있는지 확인
            if (board[x][y] != ' ') {
                System.out.println("다시 선택하세요.");
                continue;
            } else {
                board[x][y] = 'O';
            }
            System.out.printf("사용자 턴(x y): %d %d", x, y);
            System.out.println();
            t.print();

            //컴퓨터
            System.out.println("컴퓨터 턴");
            t.comRandom();
            boolean ck = true;
            while(ck) {
                if (board[comx][comy] != ' ') {
                    t.comRandom();
                } else {
                    board[comx][comy] = 'X';
                    ck = false;
                }
            }
            t.print();
            count ++;
            
            //해결해야함
            if (count >= 3) {
                //가로
                t.ticTacToe("row",'O');
                t.ticTacToe("row",'X');
                //세로
                t.ticTacToe("col",'O');
                t.ticTacToe("col",'X');
                //대각선
                t.ticTacToe("diag", 'O');

                if (user == 3) {
                    System.out.println("사용자가 승리하였습니다!");
                    check = false;
                }
                else if (com == 3) {
                    System.out.println("컴퓨터가 승리하였습니다!");
                    check  = false;
                }
            }

        }while(check);
    }

    private void print() {
        for (int i=0; i< board.length; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---|---|---");
            }
        }
    }
    private void comRandom() {
        Random random = new Random();
        comx = random.nextInt(2) + 1;
        comy = random.nextInt(2) + 1;
    }

    private void ticTacToe(String str, char ch) {
        user = 0;
        com = 0;
        switch (str) {
            case "row":
                if (ch == 'O') {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (board[i][j] == 'O') {
                                user++;
                            } else {
                                break;
                            }
                        }
                    }
//                    return user;
                }

                if (ch == 'X') {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (board[i][j] == 'X') {
                                com++;
                            } else {
                                break;
                            }
                        }
                    }
//                    return com;
                }
                break;

            case "col":
                if (ch == 'O') {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (board[j][i] == 'O') {
                                user++;
                            } else {
                                break;
                            }
                        }
                    }
//                    return user;
                }

                if (ch == 'X') {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (board[j][i] == 'X') {
                                com++;
                            } else {
                                break;
                            }
                        }
                    }
//                    return com;
                }
                break;

            case "diag":
                if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
                    user = 3;
                } else if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
                    user = 3;
                }
//                return user;
                break;
            default:
                System.out.println("잘못된 입력!");
//                return 0;
                break;
        }
    }
}
