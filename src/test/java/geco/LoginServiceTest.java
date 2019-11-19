package geco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private LoginService ls;
    private String[] logins = {
            "ZeLogin",
            "MyLogin",
            "MyOtherLogin"
    };
    @Before
    public void setUp() {
        this.ls = new LoginService(this.logins);
    }

    @After
    public void tearDown() {
        this.ls = null;
    }

    @Test
    public void loginExists() {
        assertTrue(ls.loginExists("MyLogin"));
    }

    @Test
    public void loginDoesntExist() {
        assertFalse(ls.loginExists("myLogin"));
    }

    @Test
    public void addLogin() {
        ls.addLogin("Youpi");
        assertTrue(ls.loginExists("Youpi"));
    }

    @Test
    public void findAllLoginsStartingWithTwoResults() {
        //GIVEN
        Object[] expected = {
                "MyLogin",
                "MyOtherLogin",
        };
        //WHEN
        Object[] actual = ls.findAllLoginsStartingWith("My").toArray();
        //THEN
        assertArrayEquals(expected,actual);
    }

    @Test
    public void findAllLoginsStartingWithNoResults() {
        //GIVEN
        Object[] expected = {};
        //WHEN
        Object[] actual = ls.findAllLoginsStartingWith("YOUHOU").toArray();
        //THEN
        assertArrayEquals(expected,actual);
    }

    @Test
    public void findAllLogins() {
        Object[] expected = {
                "MyLogin",
                "MyOtherLogin",
                "ZeLogin"
        };
        Object[] actual = ls.findAllLogins().toArray();
        assertArrayEquals(expected,actual);
    }
}