public class EncryptionEngine {

    private Controller contr;
    private int encryptionKey; 

    public  EncryptionEngine(Controller controll) {
        this.contr = controll;
    }

    public void setEncryptionKey(int key) {
        this.encryptionKey = key;
    }

    public int getEncryptionKey() {
        System.out.println(encryptionKey);
        return this.encryptionKey;

    }

    public String encrypt(String inputText) {
        char[] inCharArr = inputText.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < inCharArr.length; i++) {
            char c = inCharArr[i];
            if (Character.isLetter(c)) {
                c = (char) (c - 'A');
                c += this.encryptionKey;
                c %= 26;
                c += 'A';
            }
            str.append(c);
        }
        return str.toString();
    }
    
    public String decrypt(String inputText) {
        char[] inCharArr = inputText.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < inCharArr.length; i++) {
            char c = inCharArr[i];
            if (Character.isLetter(c)) {
                c = (char) (c - 'A');
                c -= this.encryptionKey;
                while (c < 0) {
                    c += 26;
                }
                c %= 26;
                c += 'A';
            }
            str.append(c);
        }
        return str.toString();
    }
}