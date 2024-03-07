/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.services;

import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mahjouba
 */
@Stateless
public class BooksService {


    @PersistenceContext
    EntityManager em;

    

    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/javaeefinal";
    final String USER_NAME = "root";

   
    
    
    
    
    public List<Book> getAllBooks() {
        List<Book> booksList=new ArrayList<>();

            Connection connection = null;
            PreparedStatement preparedStatement = null;

        try {

            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, "");
            String sql = "SELECT * FROM `books`";

            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getInt(1));
                book.setBookName(resultSet.getString("book_name"));
                Subject subject =new Subject();
                subject.setSubId(resultSet.getInt("sub_id"));
                book.setSubId(subject);
                booksList.add(book);

            }
            connection.close();
            preparedStatement.close();

        } catch (Exception e) {
e.printStackTrace();
        }

        return booksList;
    }
    
    

    public boolean addBook(Book book) {
        boolean isAdded =false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            // Database connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, "");

            // Insert user information into the database
            String sql = "INSERT INTO books (book_name, sub_id) VALUES ( ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            
                // Assuming you store the current user's ID in a session variable

                preparedStatement.setString(1, book.getBookName());
                preparedStatement.setObject(2, book.getSubId());
                
                int rowCount = preparedStatement.executeUpdate();

                if (rowCount > 0) {
                    isAdded=true;
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
    
    
    
    
    
    
    
    



}
