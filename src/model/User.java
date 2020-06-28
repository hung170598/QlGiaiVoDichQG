/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hung1
 */
public class User {
    private String usename;
    private String password;
    private String position;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String usename, String password) {
        this.usename = usename;
        this.password = password;
    }

    public String getUsename() {
        return usename;
    }

    public String getPassword() {
        return password;
    }

    public String getPosition() {
        return position;
    }
    
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
}