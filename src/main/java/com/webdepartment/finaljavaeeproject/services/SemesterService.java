/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.services;

import com.webdepartment.finaljavaeeproject.entities.Semester;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mahjouba
**/
@Stateless
public class SemesterService {
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/javaeefinal";
    final String USER_NAME = "root";

   
    public List<Semester> getAllSemesters() {
        List<Semester> semestersList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, "");
            String sql = "SELECT * FROM `semesters`";

            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Semester semester = new Semester();
                semester.setSemId(resultSet.getInt(1));
                semester.setSemName(resultSet.getString("sem_name"));
                semestersList.add(semester);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

        return semestersList;
    }

    public List<Subject> getSubjectsForSemester(Semester semesterId) {
        List<Subject> subjectsList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, "");
            String sql = "SELECT * FROM `subjects` WHERE `sem_id` = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, semesterId.getSemId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setSubId(resultSet.getInt(1));
                subject.setSubName(resultSet.getString("sub_name"));
                subjectsList.add(subject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

        return subjectsList;
    }

    
    public Semester findSemesterById(int semId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

            Semester semester = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, "");
            preparedStatement = connection.prepareStatement("SELECT * FROM semesters WHERE sem_id = ?");
            preparedStatement.setInt(1, semId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int sem_id=resultSet.getInt("sem_id");
                String sem_name=resultSet.getString("sem_name");
                semester =new Semester(sem_id,sem_name);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
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

        return semester;
    }


}
