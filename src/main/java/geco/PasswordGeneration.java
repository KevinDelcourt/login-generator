package geco;

import java.util.Random;

/**
 * Générer un mot de passe aléatoire.
 */
public final class PasswordGeneration {

    private static final String ALL_CHARS = "azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN1234567890?./+%£*&é§è!çà;";
    private static final int PASSWORD_LENGTH = 8;

    private PasswordGeneration() {

    }

    /**
     * Retourne un mot de passe aléatoire de taille 8.
     *
     * @return le mot de passe
     */
    public static String getRandomPassword() {
        Random r = new Random();
        String password = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            password += ALL_CHARS.charAt(r.nextInt(ALL_CHARS.length()));
        }
        return password;
    }
}
