package com.epam.test.service;

import com.epam.test.dao.User;
import com.epam.test.dao.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by mrinpus on 24.2.17.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() throws DataAccessException {

        LOGGER.debug("method: getAllUsers()");
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Integer userId) throws DataAccessException {

        LOGGER.debug("method: getUserById()", userId);
        Assert.notNull(userId, "User Id should not be NULL!");
        return userDao.getUserById(userId);
    }

    @Override
    public User getUserByLogin(String login) throws DataAccessException {

        LOGGER.debug("method: getUserByLogin()", login);
        Assert.notNull(login);
        return userDao.getUserByLogin(login);
    }

    @Override
    public Integer addUser(User user) throws DataAccessException {

        LOGGER.debug("method: addUser()", user.toString());
        Assert.notNull(user);
        Assert.isNull(user.getUserId(), " User Id should be NULL!");
        Assert.hasText(user.getLogin(), "User login should not be NULL!");
        Assert.hasText(user.getPassword(), "User password should not be NULL!");

        Integer userId = userDao.addUser(user);
        return userId;
    }

    @Override
    public int updateUser(User user) throws DataAccessException {

        LOGGER.debug("method: updateUser()", user.toString());
        Assert.notNull(user);
        Assert.hasText(user.getLogin(), "User Login should not be NULL!");
        Assert.hasText(user.getPassword(), "User Login should not be NULL!");
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(Integer userId) throws DataAccessException {

        LOGGER.debug("deleteUser():", userId);
        Assert.notNull(userId, "User id should not be null.");
        return userDao.deleteUser(userId);
    }
}
