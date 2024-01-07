public class Player {
    private char symbol;

    public Player(char symbol) {   //tilldela spelarens symbolobjekt en symbol
        this.symbol = symbol;
    }

    public char getSymbol() {  //returnera symbolen
        return symbol;
    }
}
