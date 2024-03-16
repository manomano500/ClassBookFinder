/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.services;

import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.entities.Department;
import com.webdepartment.finaljavaeeproject.entities.Semester;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author mahjouba
 */
@Stateful

public class DepartmentsService extends AbstractClass{
    
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

 public List<Department> getDepartments(){
     
     return em.createNamedQuery("Department.findAll",Department.class).getResultList();
 
 
 }
 
    public List<Subject> getSemesterSubjectsForDepartment(Semester semester, Department department) {
        Query query = em.createQuery(
                "SELECT subj FROM Subject subj WHERE subj.semesterID = :semester AND subj.departmentID = :department");
        query.setParameter("semester", semester);
        query.setParameter("department", department);
        return query.getResultList();
    }
    public List<Subject> getDepartmentSubjects(Department department) {
        Query query = em.createQuery(
                "SELECT subj FROM Subject subj WHERE subj.departmentID = :department");
//                query.setParameter("semester", semester);
        query.setParameter("department", department);
        return query.getResultList();


    }
   
}
