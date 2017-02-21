package com.epam.test.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mrinpus on 20.2.17.
 */
public class UserTest {

    private  static  final Logger LOGGER = LogManager.getLogger();

    @Test
    public void getUserId() throws Exception {
        LOGGER.debug("Test getUserID()");
        User user = new User();
        user.setUserId(13);
        Assert.assertEquals("User Id: ", (Integer)13, user.getUserId());
    }

    @Test
    public void getLogin() throws Exception {

        LOGGER.debug("Test getUserLogin()");
        User user = new User();
        user.setLogin("UnknownLogin");
        Assert.assertEquals("User Login: ", "UnknownLogin", user.getLogin());

    }

    @Test
    public void getPassword() throws Exception {

        LOGGER.debug("Test getUserPassword()");
        User user = new User();
        user.setPassword("12345");
        Assert.assertEquals("User Password: ", "12345", user.getPassword());
    }

    @Test
    public void getDescription() throws Exception {

        LOGGER.debug("Test getUserDescription()");
        User user = new User();
        user.setDescription("User");
        Assert.assertEquals("User Description: ", "User", user.getDescription());
    }

    @Test
    public void setUserId() throws Exception {

        LOGGER.debug("Test setUserId()");
        User user = new User();
        user.setUserId(777);
        Assert.assertEquals("User Id: ", (Integer)777, user.getUserId());

    }

    @Test
    public void setLogin() throws Exception {

        LOGGER.debug("Test setUserLogin()");
        User user = new User();
        user.setLogin("AnotherLogin");
        Assert.assertEquals("User Login: ", "AnotherLogin", user.getLogin());

    }

    @Test
    public void setPassword() throws Exception {

        LOGGER.debug("Test setUserPassword()");
        User user = new User();
        user.setPassword("09876");
        Assert.assertEquals("User Password: ", "09876", user.getPassword());

    }

    @Test
    public void setDescription() throws Exception {

        LOGGER.debug("Test setUserDescription()");
        User user = new User();
        user.setDescription("XXX");
        Assert.assertEquals("User Description: ", "XXX", user.getDescription());

    }

}