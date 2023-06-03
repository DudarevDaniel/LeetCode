package medium.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku main = new ValidSudoku();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean result = main.isValidSudoku(board);
        System.out.println(result);
    }

    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> columnChars = new ArrayList<>(9);
        for (int i = 0; i < board.length; i++) {
            columnChars.add(new HashSet<>(9));
        }
        List<Set<Character>> boxChars = new ArrayList<>(3);
        for (int row = 0; row < board.length; row++) {
            Set<Character> rowChars = new HashSet<>(9);
            if (row % 3 == 0) {
                boxChars = new ArrayList<>(3);
                for (int i = 0; i <= 2; i++) {
                    boxChars.add(new HashSet<>());
                }
            }
            for (int column = 0; column < board[0].length; column++) {
                char current = board[row][column];
                if (current != '.') {
                    if (!rowChars.add(current)) {
                        return false;
                    }
                    Set<Character> currentBox = boxChars.get(column / 3);
                    if (!currentBox.add(current)) {
                        return false;
                    }
                    Set<Character> currentColumn = columnChars.get(column);
                    if (!currentColumn.add(current)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
