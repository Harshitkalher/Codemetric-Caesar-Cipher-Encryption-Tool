import java.util.Scanner;

public class CaesarCipher {

    // Method to encrypt the text
    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                // Shift character within the bounds of the alphabet
                encrypted.append((char) ((c - base + shift) % 26 + base));
            } else {
                // Non-alphabetical characters are not changed
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    // Method to decrypt the text
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);  // Reverse the encryption process
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to encrypt: ");
        String inputText = scanner.nextLine();
        
        System.out.print("Enter shift value (0-25): ");
        int shift = scanner.nextInt();

        // Encrypting the text
        String encryptedText = encrypt(inputText, shift);
        // Decrypting the text
        String decryptedText = decrypt(encryptedText, shift);

        // Displaying results
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
        
        scanner.close();
    }
}