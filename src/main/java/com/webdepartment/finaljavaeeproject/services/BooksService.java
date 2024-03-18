/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.services;

import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.entities.Department;
import com.webdepartment.finaljavaeeproject.entities.Semester;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
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
@Stateful
public class BooksService extends AbstractClass {


    @PersistenceContext
    EntityManager em;

    

    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/javaeefinal";
    final String USER_NAME = "root";

   
    public List<Book> getAllBooks() {
        List<Book> booksList = new ArrayList<>();
        booksList=em.createNamedQuery("Book.findAll",Book.class).getResultList();
        return booksList;
    }
    
    
    
    
    
    
    
    public void addBook(Book book){
       
       
            em.persist(book);
            
        
    }
    
   
      public List<Book> findBooksByDepartmentSemesterSubject(Department department, Semester semester, Subject subject) {
        return em.createQuery(
                "SELECT b FROM Book b WHERE b.departmentID = :department AND b.semesterID = :semester AND b.subjectID = :subject",
                Book.class)
                .setParameter("department", department)
                .setParameter("semester", semester)
                .setParameter("subject", subject)
                .getResultList();
      }
}