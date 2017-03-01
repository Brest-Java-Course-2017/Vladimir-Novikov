package com.epam.test.client;

import com.epam.test.client.exception.ServerDataAccessException;
import com.epam.test.client.rest.api.UsersConsumer;
import com.epam.test.dao.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Users Consumer with REST.
 */
public class UsersConsumerRest implements UsersConsumer {

    @Value("${user.protocol}://${user.host}:${user.port}/")
    private String url;

    @Value("${point.users}")
    private String urlUsers;

    @Value("${point.user}")
    private String urlUser;

    ClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    RestTemplate restTemplate = new RestTemplate(requestFactory);
    {
        restTemplate.setErrorHandler(new CustomResponseErrorHandler());
    }

    @Override
    public List<User> getAllUsers() throws ServerDataAccessException {
        ResponseEntity responseEntity = restTemplate.getForEntity(url + urlUsers, Object.class);
        List<User> users = (List<User>) responseEntity.getBody();
        return users;
    }

    @Override
    public User getUserById(Integer userId) throws ServerDataAccessException {
        return null;
    }

    @Override
    public User getUserByLogin(String login) throws ServerDataAccessException {
        ResponseEntity responseEntity = restTemplate.getForEntity(url + urlUser + "/" + login, Object.class);
        User user = (User) responseEntity.getBody();
        return user;
    }

    @Override
    public Integer addUser(User user) throws ServerDataAccessException {
        return null;
    }

    @Override
    public int updateUser(User user) throws ServerDataAccessException {
        return 0;
    }

    @Override
    public int deleteUser(Integer userId) throws ServerDataAccessException {
        return 0;
    }
}
