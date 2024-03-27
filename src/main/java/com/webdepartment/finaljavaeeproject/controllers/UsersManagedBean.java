/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.controllers;

import com.webdepartment.finaljavaeeproject.entities.User;
import com.webdepartment.finaljavaeeproject.services.SemestersService;
import com.webdepartment.finaljavaeeproject.services.UsersService;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author mahjouba
 */
public class UsersManagedBean implements Serializable{

    /**
     * Creates a new instance of UsersManagedBean
     */
    public UsersManagedBean() {
    }
    
    @Inject
    @EJB
    private UsersService usersService;
    
       
    private boolean loggedIn; // Property to represent user's authentication status

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


    private String username;

    
    private String password;
    private User user ;
 

    public User getUser() {
        return user;
    }
    
    public String login() {
        if (usersService.authenticate(username, password)) {
            loggedIn = true;
            user =usersService.getLoggedInUser(username);


            return "admin1.xhtml?faces-redirect=true";
        } else {
            // Authentication failed, show an error message or redirect back to the login page
            return "login.xhtml?faces-redirect=true&error=true";
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void redirectToLoginIfNotLoggedIn() throws IOException {
        if (!loggedIn) {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath() + "/login.xhtml");
        }
    }
}
