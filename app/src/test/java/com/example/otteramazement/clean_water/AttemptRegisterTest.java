package com.example.otteramazement.clean_water;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Emma on 4/2/2017.
 *
 */


public class AttemptRegisterTest {

    private final RegisterActivity r = new RegisterActivity();

    @Before
    public void beforeTest() {
        OurHashMap.userMap.remove("User");
    }

    @Test
    public void passMatch() {
        r.register("password", "password", "User", "User", ProfileType.USER, false);
        Assert.assertTrue("This should register a user.", OurHashMap.userMap.containsKey("User"));
    }

    @Test
    public void passNotMatch() {
        r.register("password", "pass", "User", "User", ProfileType.ADMIN, false);
        Assert.assertTrue("This should not register a user because the passwords do not match.", !OurHashMap.userMap.containsKey("User"));
    }

    @Test
    public void userShort() {
        r.register("password", "password", "Us", "Us", ProfileType.WORKER, false);
        Assert.assertTrue("This should not register a user because the username is too short.", !OurHashMap.userMap.containsKey("Us"));
    }

    @Test
    public void nameShort() {
        r.register("pass", "pass", "User", "A", ProfileType.ADMIN, false);
        Assert.assertTrue("This should not register a user because the name is too short.", !OurHashMap.userMap.containsKey("User"));
    }
}
