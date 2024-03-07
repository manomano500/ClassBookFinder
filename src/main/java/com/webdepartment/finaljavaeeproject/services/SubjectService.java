/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.services;

import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.entities.Semester;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mahjouba
 */
@Stateless
public class SubjectService {
    
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/javaeefinal";
    final String USER_NAME = "root";



    public List<Subject> getAllSubjects() {
        List<Subject> subjectsList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, "");
            String sql = "SELECT * FROM `subjects` WHERE '1'";

            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setSubId(resultSet.getInt(1));
                subject.setSubName(resultSet.getString("book_name"));
                Semester semester = new Semester();
                semester.setSemId(resultSet.getInt("sem_id"));
                subject.setSemId(semester);
                subjectsList.add(subject);

            }
            connection.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subjectsList;
    }

    public boolean addSubject(Subject subject) {
        boolean isAdded = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Database connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, "");

            // Insert user information into the database
            String sql = "INSERT INTO `subjects` (sub_name, sem_id) VALUES ( ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Assuming you store the current user's ID in a session variable
            preparedStatement.setString(1, subject.getSubName());
            preparedStatement.setInt(2, subject.getSemId().getSemIdAInt());

            int rowCount = preparedStatement.executeUpdate();

            if (rowCount > 0) {
                isAdded = true;
                // Insertion successful

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isAdded;

    }

    
        @PersistenceContext
    private EntityManager entityManager;


}

