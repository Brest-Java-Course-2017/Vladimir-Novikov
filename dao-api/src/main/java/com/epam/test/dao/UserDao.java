package com.epam.test.dao;

import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by mrinpus on 21.2.17.
 */

public interface UserDao {

    List<User> getAllUsers() throws DataAccessException;

    User getUserById(Integer userId) throws DataAccessException;

    User getUserByLogin(String login) throws DataAccessException;

    Integer addUser(User user) throws DataAccessException;

    int updateUser(User user) throws DataAccessException;

    int deleteUser(Integer userId) throws DataAccessException;
}
