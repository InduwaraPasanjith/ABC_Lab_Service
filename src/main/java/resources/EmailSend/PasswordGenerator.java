/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.EmailSend;
import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]|,./?><";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;

    private static SecureRandom random = new SecureRandom();

    public static String generateRandomPassword(int length) {
        if (length < 4) throw new IllegalArgumentException("The length must be at least 4 characters.");

        StringBuilder password = new StringBuilder(length);

        // Create a character set for password generation
        String combinedChars = PASSWORD_ALLOW_BASE;
        
        // At least one lower-case character
        password.append(CHAR_LOWER.charAt(random.nextInt(CHAR_LOWER.length())));
        
        // At least one upper-case character
        password.append(CHAR_UPPER.charAt(random.nextInt(CHAR_UPPER.length())));
        
        // At least one digit
        password.append(NUMBER.charAt(random.nextInt(NUMBER.length())));

        // Fill the rest of the password with random characters
        for (int i = 0; i < length - 3; i++) {
            password.append(combinedChars.charAt(random.nextInt(combinedChars.length())));
        }

        return password.toString();
    }
}
