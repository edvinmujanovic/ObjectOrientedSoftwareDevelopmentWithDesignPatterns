import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Board board;
    private RuleEngine ruleEngine;
    private Player[] players;
    private int currentPlayerIndex;
    private boolean gameover; 

    public Controller() {
        view = new View(3); // Board storlek justera
        board = new Board(3); // Board storlek justera
        ruleEngine = new RuleEngine(board, 3); // Ändra condition för vinst
        players = new Player[] { new Player('O'), new Player('X') }; //tilldelar nya spelare
        currentPlayerIndex = 0;  //tilldelar indexet som spelaren man är på börjar på, noll i detta fall
        gameover = false;  //gameover börjar alltid på false
    }

    public void handleClick(int x, int y) {
        if (gameover || board.getCell(x, y) != ' ') {
            return;
        }

        char currentPlayerSymbol = players[currentPlayerIndex].getSymbol();
        board.setCell(x, y, currentPlayerSymbol);
        view.setButtonLabel(x, y, currentPlayerSymbol);

        if (ruleEngine.checkWin(x, y, currentPlayerSymbol)) {
            view.setTurnLabel("Player " + (currentPlayerIndex + 1) + " won!");
            gameover = true;
        } else if (board.isBoardFull()) {
            view.setTurnLabel("It's a draw!");
            gameover = true;
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
            view.setTurnLabel("Player " + (currentPlayerIndex + 1) + "'s turn");
        }
    }

    public void startGame() {
        for (int x = 0; x < board.getSize(); x++) {
            for (int y = 0; y < board.getSize(); y++) {
                final int currentX = x;
                final int currentY = y;
                view.addButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleClick(currentX, currentY);
                    }
                }, x, y);
            }
        }
        view.setTurnLabel("Player 1's turn");
    }
}