package com.epam.test.service;

import com.epam.test.dao.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mrinpus on 24.2.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-test.xml"})
@Transactional
public class UserServiceImplTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    UserService userService;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        LOGGER.error("execute: setUpBeforeClass()");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception{
        LOGGER.error("execute: tearDowmAfterClass()");
    }

    @Before
    public void beforeTest(){
        LOGGER.error("execute: beforeTest()");
    }

    @After
    public void afterTest(){
        LOGGER.error("execute: afterTest()");
    }

    @Test
    public void getAllUsersTest() throws Exception {

        LOGGER.debug("test method: getAllUsers() ");
        List<User> users = userService.getAllUsers();
        assertTrue(users.size() == 2);
    }

    @Test
    public void getUserByIdTest() throws Exception {

        LOGGER.debug("test method: getUserById()");
        User user = userService.getUserById(1);
        assertNotNull(user);
        assertEquals((Integer)1, user.getUserId());

    }

    @Test
    public void getUserByLoginTest() throws Exception {

        LOGGER.debug("method: getUserByLogin()");
        User user = userService.getUserByLogin("userLogin1");
        assertNotNull(user);
        assertNotNull(user.getLogin());
        assertEquals("Compare logins: ", "userLogin1", user.getLogin());

    }

    @Test
    public void addUserTest() throws Exception {

        LOGGER.debug("test method: addUser()");
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        Integer numberOfUsers = users.size();

        User user = new User("userLogin3", "userPassword3");
        assertNotNull(user);
        Integer userId = userService.addUser(user);
        assertNotNull(userId);

        User newUser = userService.getUserById(userId);
        assertNotNull(newUser);

        assertTrue(user.getLogin().equals(newUser.getLogin()));
        assertTrue(user.getPassword().equals(newUser.getPassword()));
        assertNull(user.getDescription());

        users = userService.getAllUsers();
        assertNotNull(users);
        assertTrue(numberOfUsers < users.size());

    }

    @Test
    public void updateUserTest() throws Exception {

        LOGGER.debug("test method: updateUser()");
        User user = userService.getUserById(1);
        assertNotNull(user);
        user.setPassword("new password");
        user.setDescription("new description");

        int count = userService.updateUser(user);
        assertEquals(1, count);

        User updateUser = userService.getUserById(user.getUserId());
        assertTrue(user.getLogin().equals(updateUser.getLogin()));
        assertTrue(user.getPassword().equals(updateUser.getPassword()));
        assertTrue(user.getDescription().equals(updateUser.getDescription()));

    }

    @Test
    public void deleteUserTest() throws Exception {

        LOGGER.debug("test method: deleteUser()");
        User user = new User("userLogin3", "userPassword3");
        assertNotNull(user);
        Integer userId = userService.addUser(user);
        assertNotNull(userId);

        List<User> users = userService.getAllUsers();
        Integer numderOfUsers = users.size();

        int count = userService.deleteUser(userId);
        assertEquals(1, count);


        users = userService.getAllUsers();
        assertTrue(numderOfUsers > users.size());
    }

}