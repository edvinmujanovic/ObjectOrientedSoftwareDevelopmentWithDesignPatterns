public class Board {
    private char[][] board; 
    private int size;

    public Board(int size) {  //konstruktor
        this.size = size;  //tilldelar storlek(inparameter) till denna boardens storlek
        this.board = new char[size][size];  //lägger in stolrken i boarden på 2 dimensioner
        initializeBoard();  //initierar boarde, kallar på funktionen nedan som löser det
    }

    private void initializeBoard() {  //loopar igenom stoleken på rad och kollumn och lägger en tom ruta för varje
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                board[x][y] = ' ';
            }
        }
    }

    public int getSize() {  //returnar stoleksvariaveln
        return size;
    }

    public char getCell(int x, int y) {  //returnerar boarden med den aktuella storleken efter att man skickat in x och y 
        return board[x][y];
    }

        public char[][] getBoard() { //returnar boarden med char värde
        return board;
    }

    public void setCell(int x, int y, char symbol) {  //skickar in en symbol i en speciell x och y koordinat och lägger till den
        board[x][y] = symbol; //lägger in symbol i den specifika rutan
    }

    public boolean isBoardFull() { //checkar om boarden är full, loopar igenom varenda koordinat i nästlad loop
        for (int x = 0; x < size; x++) { //loopar igenom x koordinater
            for (int y = 0; y < size; y++) { //loopar igenom y koordinater
                if (board[x][y] == ' ') {  //så fort en ruta är tom/inte innehåller en symbol returnera false
                    return false;
                }
            }
        }
        return true; //har alla rutor en symbol returnera true, den är full
    }
}
