/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.services;

import com.webdepartment.finaljavaeeproject.controllers.DepartmentManagedBean;
import com.webdepartment.finaljavaeeproject.entities.Department;
import com.webdepartment.finaljavaeeproject.entities.Semester;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mahjouba
 */
@Stateful
public class SemestersService {
//       @EJB


    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }


   
  
    public List<Semester> feachAllSemesters() {
        return em.createNamedQuery("Semester.findAll",Semester.class).getResultList();
    
    }

}

