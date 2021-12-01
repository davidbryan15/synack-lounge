package com.aviles.entity;

import javax.persistence.*;

@Entity
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credentials_id")
    private int credentialsId;

    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String pass;

    @OneToOne(mappedBy = "credentials", cascade = CascadeType.ALL)
    private User user;

    public Credentials() {
    }

    public Credentials(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public int getCredentialsId() {
        return credentialsId;
    }

    public void setCredentialsId(int credentialsId) {
        this.credentialsId = credentialsId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "credentialsId=" + credentialsId +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", user=" + user +
                '}';
    }

    public boolean isEmpty(){
        return this.username.trim().isEmpty() || this.pass.trim().isEmpty();
    }
}
