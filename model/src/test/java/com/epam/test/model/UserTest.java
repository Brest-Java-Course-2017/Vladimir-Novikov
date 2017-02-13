package com.epam.test.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mrinpus on 13.2.17.
 */
public class UserTest {
    @Test
    public void getUserId() throws Exception {
        User user = new User();
        user.setUserId(131);
        Assert.assertEquals("User ID: ", (Integer)131, user.getUserId());
    }

    @Test
    public void getLogin() throws Exception {
        User user =new User();
        user.setLogin("Vasya Pupkin");
        Assert.assertEquals("User Login: ", "Vasya Pupkin", user.getLogin());
    }

    @Test
    public void getPassword() throws Exception {
        User user = new User();
        user.setPassword("pass");
        Assert.assertEquals("User Password: ", "pass", user.getPassword());
    }

    @Test
    public void getDescription() throws Exception {
        User user = new User();
        user.setDescription("User Description: ", "WTF?", user.getDescription());
    }

}