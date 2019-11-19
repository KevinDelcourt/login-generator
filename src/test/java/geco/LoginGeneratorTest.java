package geco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    private LoginGenerator lg;

    @Before
    public void setUp() {
        String[] logins = {
                "MyLogin",
                "AnotherLogin"
        };
        LoginService loginService = new LoginService(new String[] {"JROL","BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        this.lg = new LoginGenerator(loginService);
    }

    @After
    public void tearDown() {
        this.lg = null;
    }

    @Test
    public void CT1() {
        String actual = this.lg.generateLoginForNomAndPrenom("Durand","Paul");
        assertEquals("PDUR",actual);
    }

    @Test
    public void loginSuffixIsIncremented() {
        String actual = this.lg.generateLoginForNomAndPrenom("Ralling","John");
        assertEquals("JRAL2",actual);
    }

    @Test
    public void CT2() {
        String actual = this.lg.generateLoginForNomAndPrenom("Rolling","Jean");
        assertEquals("JROL1",actual);
    }

    @Test
    public void CT3() {
        String actual = this.lg.generateLoginForNomAndPrenom("Dùrand","Paul");
        assertEquals("PDUR",actual);
    }
}