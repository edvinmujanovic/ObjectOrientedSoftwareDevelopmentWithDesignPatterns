public class RuleEngine {
    private Board board;
    private int winCondition;

    public RuleEngine(Board board, int winCondition) {
        this.board = board;
        this.winCondition = winCondition;
    }

    public boolean checkWin(int x, int y, char symbol) { //kollar om man vunnit
        return checkHorizontal(x, y, symbol) || checkVertical(x, y, symbol) || checkDiagonal(x, y, symbol); //ropar på alla funktioner som kollar om man vunnit
    }

    private boolean checkHorizontal(int x, int y, char symbol) { //loopar igenom o kollar allt horizontellt
        int count = 1;
        for (int i = x - 1; i >= 0 && board.getCell(i, y) == symbol; i--) {
            count++;
        }
        for (int i = x + 1; i < board.getSize() && board.getCell(i, y) == symbol; i++) {
            count++;
        }
        return count >= winCondition;
    }

    private boolean checkVertical(int x, int y, char symbol) { //loopar igenom o kollar allt vertikalt
        int count = 1;
        for (int i = y - 1; i >= 0 && board.getCell(x, i) == symbol; i--) {
            count++;
        }
        for (int i = y + 1; i < board.getSize() && board.getCell(x, i) == symbol; i++) {
            count++;
        }
        return count >= winCondition;
    }

    private boolean checkDiagonal(int x, int y, char symbol) { //loopar igenom o kollar allt Diagonalt
        int count = 1;
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0 && board.getCell(i, j) == symbol; i--, j--) {
            count++;
        }
        for (int i = x + 1, j = y + 1; i < board.getSize() && j < board.getSize() && board.getCell(i, j) == symbol; i++, j++) {
            count++;
        }
        if (count >= winCondition) {
            return true;
        }

        count = 1;
        for (int i = x - 1, j = y + 1; i >= 0 && j < board.getSize() && board.getCell(i, j) == symbol; i--, j++) {
            count++;
        }
        for (int i = x + 1, j = y - 1; i < board.getSize() && j >= 0 && board.getCell(i, j) == symbol; i++, j--) {
            count++;
        }
        return count >= winCondition;
    }
}
