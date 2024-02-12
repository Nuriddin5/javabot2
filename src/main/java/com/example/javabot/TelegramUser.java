package com.example.javabot;

/**
 * User:t.me/supermatematikuz
 * Date:12.02.2024 10:45
 */
public class TelegramUser {
    private Long id;

    private String firstName;

    private String username;

    //todo add bio vs profileImage, ...


    public TelegramUser() {
    }

    public TelegramUser(Long id, String firstName, String username) {
        this.id = id;
        this.firstName = firstName;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "TelegramUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
