/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.services;

import com.webdepartment.finaljavaeeproject.aice.SemesterEnum;
import static com.webdepartment.finaljavaeeproject.aice.SemesterEnum.convertStringToSemesterEnum;
import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.entities.Department;
import com.webdepartment.finaljavaeeproject.entities.Semester;
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

    


    @Transactional
    public void addSubject(Subject subject){
        em.persist(subject);
        
        
    }
   
    @Transactional
    public void deleteSubject(int subId) {
        Subject subject = em.find(Subject.class, subId);
        if (subject != null) {
            em.remove(subject);
        }
    }
    
      
    @Transactional
    public Subject findSubById(int subId) {
        return em.find(Subject.class, subId);
    }
    
    
    @Transactional
    public Subject findSubjectby(int subId) {
        return em.find(Subject.class, subId);
    }
    
    
    public List<Subject> getSubjectsForDepartment(Department department) {
        // Construct the JPQL query to fetch subjects for the given department
        String jpql = "SELECT s FROM Subject s WHERE s.departmentID = :department";

        // Execute the query and bind parameters
        List<Subject> subjects = em.createQuery(jpql, Subject.class)
                .setParameter("department", department)
                .getResultList();

        return subjects;
    }

    
    
    public List<Subject> getAllSubjects(){
        List<Subject> subjectsList = new ArrayList<>();
        
        subjectsList= em.createNamedQuery("Subject.findAll", Subject.class).getResultList();
        
        return subjectsList;

    
    }
    public List<Subject> getSubjectsForSemesterDepartment(Semester semester, Department department) {
        // Construct the JPQL query to fetch subjects for the given semester and department
        String jpql = "SELECT s FROM Subject s WHERE s.semesterID = :semester AND s.departmentID = :department";

        // Execute the query and bind parameters
        List<Subject> subjects = em.createQuery(jpql, Subject.class)
                .setParameter("semester", semester)
                .setParameter("department", department)
                .getResultList();

        return subjects;
    }


   
}

