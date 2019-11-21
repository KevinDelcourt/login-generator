package geco;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGenerationTest {

    @Test
    public void getRandomPassword() {
        String password = PasswordGeneration.getRandomPassword();
        assertEquals(8,password.length());
    }
}