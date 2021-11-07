import java.util.ArrayList;
import java.util.List;

public class puppetDraw {
    public static void main(String[] args) {

        int[][] board = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int a = solution(board, moves);
        System.out.println(a);
    }

    static int solution(int[][] board, int[] moves) {
        // 뽑힌 인형 list
        List<Integer> pickedDolls = new ArrayList<Integer>();

        int boardSize = board.length;
        int answer = 0;

        for (int i = 0; i < moves.length; i++) {
            int move = moves[i] - 1;

            for (int j = 0; j < boardSize; j++) {
                if (board[j][move] != 0) {
                    pickedDolls.add(board[j][move]);
                    board[j][move] = 0;
                    break;
                }
            }

            // 뽑힌 인형 이전과 같은지 비교 후 같으면 둘다 삭제..?
            if (pickedDolls.size() > 1) {
                if (pickedDolls.get(pickedDolls.size() - 1) == pickedDolls.get(pickedDolls.size() - 2)) {
                    answer += 2;
                    pickedDolls.remove(pickedDolls.size() - 1);
                    pickedDolls.remove(pickedDolls.size() - 1);
                }
            }
        }
        return answer;
    }
}
