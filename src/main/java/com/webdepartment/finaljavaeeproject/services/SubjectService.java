/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.services;

import com.webdepartment.finaljavaeeproject.aice.SemesterEnum;
import static com.webdepartment.finaljavaeeproject.aice.SemesterEnum.convertStringToSemesterEnum;
import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author mahjouba
 */
@Stateful
public class SubjectService extends AbstractClass{
    
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    
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
            String sql = "SELECT * FROM `subjects` ";

            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setSubId(resultSet.getInt(1));
                subject.setSubName(resultSet.getString("sub_name"));
                
//                subject.setSemester(SemesterEnum.convertStringToSemesterEnum(resultSet.getString("semester")));
                subjectsList.add(subject);

            }
            connection.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subjectsList;
    }
    
    
    
    

    public boolean old_addSubject(Subject subject) {
        boolean isAdded = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Database connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, "");

            // Insert user information into the database
            String sql = "INSERT INTO `subjects` (sub_name, semester) VALUES ( ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Assuming you store the current user's ID in a session variable
            preparedStatement.setString(1, subject.getSubName());
//            preparedStatement.setString(2, subject.getSemester().getDisplayName());

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
    
    
    @Transactional
    public void addSubject(Subject subject){
        em.persist(subject);
        
        
    }
    
    public void deleteSubject(int subject_id) {
        Connection connection = null;
        boolean isAdded = false;

        try {
            // Database connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, "");

            // Delete user by ID
            String deleteQuery = "DELETE FROM subjects WHERE sub_id=?";
            try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
                statement.setInt(1, subject_id);

                int rowCount = statement.executeUpdate();

                if (rowCount > 0) {
                    isAdded = true;
                    // Deletion successful
                } else {
                    // Deletion failed
                }
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

    }
    
  
    public Subject findSubById(int subId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Subject subject = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, "");
            preparedStatement = connection.prepareStatement("SELECT * FROM subjects WHERE sub_id = ?");
            preparedStatement.setInt(1, subId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int sub_id = resultSet.getInt("sub_id");
                String sub_name = resultSet.getString("sub_name");
//                SemesterEnum semester =convertStringToSemesterEnum(resultSet.getString("semester"));
                subject = new Subject(sub_id, sub_name,"sem");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
        try {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        return subject;
    }

}

