/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.services;

import com.webdepartment.finaljavaeeproject.entities.Department;
import com.webdepartment.finaljavaeeproject.entities.User;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mahjouba
 */
@Stateful
public class UsersService extends AbstractClass{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    
    public boolean authenticate(String username, String password) {
        User user = em.createQuery("SELECT u FROM User u WHERE u.userName = :userName", User.class)
                .setParameter("userName", username)
                .getResultStream()
                .findFirst()
                .orElse(null);

        return user != null && user.getPassword().equals(password);
    }
    
    public User getLoggedInUser(String username) {
        if (username != null) {
            Object[] result = (Object[]) em.createQuery("SELECT u.userName, u.departmentId FROM User u WHERE u.userName = :userName")
                    .setParameter("userName", username)
                    .getSingleResult();

            User user = new User();
            user.setUserName((String) result[0]);
            user.setDepartmentId((Department) result[1]); // Assuming department is a string, adjust accordingly if it's a different type

            return user;
        } else {
            return null; // No logged-in user
        }
    }
    
    
    }
