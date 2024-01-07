import javax.swing.JOptionPane;

public class Controller {
    private View v;
    private EncryptionEngine encryption;

    public Controller() {
        this.v = new View(this);
        this.encryption = new EncryptionEngine(this);
    }

    public void encryptButtonClicked() {
        String encryptionKey = v.getEncryptionKey();
        String inputText = v.getInputText();

        if (isNumeric(encryptionKey) && isAlphaUpperCase(inputText)) {
            int key = Integer.parseInt(encryptionKey);
            encryption.setEncryptionKey(key);
            v.setOutputText(encryption.encrypt(inputText));
        } else if (!isNumeric(encryptionKey)) {
            showErrorDialog("Invalid Input", "Encryption key must be a number.");
        } else {
            showErrorDialog("Invalid Input", "Input text must contain only uppercase letters.");
        }
    }

    public void decryptButtonClicked() {
        String encryptionKey = v.getEncryptionKey();
        String inputText = v.getInputText();

        if (isNumeric(encryptionKey) && isAlphaUpperCase(inputText)) {
            int key = Integer.parseInt(encryptionKey);
            encryption.setEncryptionKey(key);
            v.setOutputText(encryption.decrypt(inputText));
        } else if (!isNumeric(encryptionKey)) {
            showErrorDialog("Invalid Input", "Encryption key must be a number.");
        } else {
            showErrorDialog("Invalid Input", "Input text must contain only uppercase letters.");
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isAlphaUpperCase(String inputText) {
        for (char c : inputText.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }

    private void showErrorDialog(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}

/*
 * public void encryptButtonClicked() {
 * if(checkIfNumberIsValid(v.getEncryptionKey()) &&
 * checkIfStringIsValid(v.getInputText())){
 * encryption.setEncryptionKey(Integer.parseInt(v.getEncryptionKey()));
 * v.setOutputText(encryption.encrypt(v.getInputText()));
 * }
 * else if(!checkIfNumberIsValid( v.getEncryptionKey()) &&
 * checkIfStringIsValid(v.getInputText())){
 * JOptionPane.showMessageDialog (null, "Only Numbers", "Title",
 * JOptionPane.ERROR_MESSAGE);
 * 
 * }
 * else{
 * JOptionPane.showMessageDialog(null, "Capital Letters Only!", "Title",
 * JOptionPane.ERROR_MESSAGE);
 * }
 * }
 * 
 * public void decryptButtonClicked() {
 * if(checkIfNumberIsValid(v.getEncryptionKey()) &&
 * checkIfStringIsValid(v.getInputText())){
 * encryption.setEncryptionKey(Integer.parseInt(v.getEncryptionKey()));
 * v.setOutputText(encryption.decrypt(v.getInputText()));
 * }
 * else if(!checkIfNumberIsValid(v.getEncryptionKey())){
 * JOptionPane.showMessageDialog (null, "Only Numbers", "Title",
 * JOptionPane.ERROR_MESSAGE);
 * }
 * else {
 * JOptionPane.showMessageDialog (null, "Capital Letters Only!", "Title",
 * JOptionPane.ERROR_MESSAGE);
 * }
 * }
 * public boolean checkIfNumberIsValid(String str){
 * 
 * try {
 * Integer.parseInt(str);
 * return true;
 * } catch (NumberFormatException e) { return false; }
 * }
 * 
 * public boolean checkIfStringIsValid(String inputText) {
 * char[] input = inputText.toCharArray();
 * for (int i = 0; i < inputText.length(); i++) {
 * if (input[i] < 65 || input[i] > 90) {
 * return false;
 * }
 * }
 * 
 * return true;
 * }
 */
