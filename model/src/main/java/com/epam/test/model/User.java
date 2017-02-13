package com.epam.test.model;

import java.util.Objects;

/**
 * Created by mrinpus on 13.2.17.
 *
 */
public class User {

    private Integer userId;

    private String login;

    private String password;

    private String description;

    public Integer getUserId() { return userId; }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDescription(String description, String s, String userDescription) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(description, user.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, description);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
