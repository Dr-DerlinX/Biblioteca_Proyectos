package clases;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {

    //Caracteres que conforman la contrasena....
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_+=<>?/{}[]|";

    private static final SecureRandom random = new SecureRandom();

    public static String generatePassword(
            int length, boolean includeUppercase, boolean includeLowercase,
            boolean includeNumbers, boolean includeSymbols){

        //Verificamos que la longitud sea mayor que 12. Se lanza una Exception de lo contrario....
        if (length < 12) throw new IllegalArgumentException("La lista de caracteres no puede ser menos de 12...!");

        StringBuilder password = new StringBuilder(length);
        String charSet = "";

        if (includeLowercase == true) charSet += LOWERCASE;
        if (includeUppercase == true) charSet += UPPERCASE;
        if (includeNumbers == true) charSet += DIGITS;
        if (includeSymbols == true) charSet += SYMBOLS;

        //Garantizamos que los caracteres selecionados aparescan al menos una ves

        if (includeLowercase) password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        if (includeUppercase) password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        if (includeNumbers) password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        if (includeSymbols) password.append(SYMBOLS.charAt(random.nextInt(DIGITS.length())));

        for (int i = password.length(); i < length; i++) {
            password.append(charSet.charAt(random.nextInt(charSet.length())));
        }
        // Mezclamos los caracteres para mejorar la aleatoriedad
        return shuffleString(password.toString());
    }

    public static String shuffleString(String input){
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while (!characters.isEmpty()) {
            int randPicker = random.nextInt(characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

}
