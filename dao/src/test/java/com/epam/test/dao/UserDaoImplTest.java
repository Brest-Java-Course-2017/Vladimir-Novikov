package com.epam.test.dao;

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
 * Created by mrinpus on 22.2.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-spring-dao.xml"})
@Transactional
public class UserDaoImplTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    UserDao userDao;

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

        LOGGER.debug("test: getAllUsers()");
        List<User> users = userDao.getAllUsers();
        assertFalse(users.size() == 0);

    }

    @Test
    public void getUserByIdTest() throws Exception {

        LOGGER.debug("test: getUserById()");
        User user = userDao.getUserById(1);
        assertNotNull(user);
        assertEquals("Compare ids", (Integer)1, user.getUserId());

    }

    @Test
    public void getUserByLoginTest() throws Exception {

        LOGGER.debug("test: getUserByLogin()");
        User user = userDao.getUserByLogin("userLogin1");
        assertNotNull(user);
        assertEquals("Compare logins", "userLogin1", user.getLogin());

    }

    @Test
    public void addUserTest() throws Exception {

        LOGGER.debug("test: addUser()");
        List<User> users = userDao.getAllUsers();
        Integer numberBefore = users.size();

        User user = new User("userLogin3", "userPassword3");
        assertNotNull(user);

        Integer userId = userDao.addUser(user);
        User newUser = userDao.getUserById(userId);
        assertNotNull(newUser);
        assertTrue("Compare users logins", user.getLogin().equals(newUser.getLogin()));
        assertTrue("Compare users passwords", user.getPassword().equals(newUser.getPassword()));

        users = userDao.getAllUsers();
        assertTrue("size + 1", users.size() > numberBefore);

    }

    @Test
    public void updateUserTest() throws Exception {

        LOGGER.debug("test: updateUser()");
        User user = userDao.getUserById(1);
        assertNotNull(user);
        user.setPassword("newPassword");
        user.setDescription("update information");

        int value = userDao.updateUser(user);
        assertEquals(1, value);

        User updateUser = userDao.getUserById(user.getUserId());
        assertNotNull(updateUser);
        assertTrue(user.getLogin().equals(updateUser.getLogin()));
        assertTrue(user.getPassword().equals(updateUser.getPassword()));
        assertTrue(user.getDescription().equals(updateUser.getDescription()));
    }

    @Test
    public void deleteUserTest() throws Exception {

        LOGGER.debug("test: deteteUser()");
        User user = new User("userLogin3", "userPassword3" );
        assertNotNull(user);
        Integer userId = userDao.addUser(user);

        List<User> users = userDao.getAllUsers();
        Integer numberOfUsers = users.size();

        int value = userDao.deleteUser(userId);
        assertEquals(1, value);

        users = userDao.getAllUsers();
        assertTrue(users.size() < numberOfUsers);
        
    }

}