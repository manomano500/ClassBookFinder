/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.controllers;

import com.webdepartment.finaljavaeeproject.aice.SemesterEnum;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mahjouba
 */
public class HelperManagedBean {

    
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/javaeefinal";
    final String USER_NAME = "root";


    /**
     * Creates a new instance of Helper
     */
    public HelperManagedBean() {
    }
    
    public List<String> feachAllSemesterEnums() {
        return Arrays.asList(
                SemesterEnum.FIRST_SEMESTER.getDisplayName(),
                SemesterEnum.SECOND_SEMESTER.getDisplayName(),
                SemesterEnum.THIRD_SEMESTER.getDisplayName(),
                SemesterEnum.FOURTH_SEMESTER.getDisplayName(),
                SemesterEnum.FIFTH_SEMESTER.getDisplayName(),
                SemesterEnum.SIXTH_SEMESTER.getDisplayName(),
                SemesterEnum.SEVENTH_SEMESTER.getDisplayName(),
                SemesterEnum.Eight_Semester.getDisplayName()
        );
    }

    public List<Subject> getSubjectsForSemester(String semesterEnum) {
        List<Subject> subjectsList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, "");
            String sql = "SELECT * FROM `subjects` WHERE `semester` = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, semesterEnum);
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

}
